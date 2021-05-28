package com.jaxon.eureka.job;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeSegment {

    //时间段大小(分钟)
    private static final int TIME_SEG = 3;
    //时间游标，从系统启动时间前推N分钟起
    private static Date CURRENT_TMIE = DateUtils.addMinutes(new Date(),-3);
    //自定义开始时间   "2020-05-11 16:47:30"
    private static String configDate = "";
    static{
        if(StringUtils.isNotBlank(configDate)){
            System.out.println("启动自定义配置");
            try {
                CURRENT_TMIE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(configDate);
            } catch (ParseException e) {
                e.printStackTrace();

            }
        }
    }


    Date startTime;

    Date endTime;

    /**
     * 获取时间段
     * @return
     */
    public static synchronized   TimeSegment getTimeSegment(){
        TimeSegment timeSegment = new TimeSegment();
        timeSegment.startTime =CURRENT_TMIE;
        Date date = DateUtils.addMinutes(CURRENT_TMIE, TIME_SEG);
        if(date.after(new Date())){//获取时间段超过当前时间
            return null;
        }else{

            timeSegment.endTime = date;
            CURRENT_TMIE = date;
        }
        System.out.println("开始："+getDateStr(timeSegment.startTime) +"  结束：  "+getDateStr(timeSegment.endTime));

        return timeSegment;
    }

    public static  String getDateStr(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    getTimeSegment();

                }
            }
        });

    }
}

