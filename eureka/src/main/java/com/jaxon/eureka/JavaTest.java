package com.jaxon.eureka;

import io.micrometer.core.instrument.util.JsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTest {

    public static String conStr(String...strs){

        return Arrays.stream(strs).reduce((to,x)->to+x).get();
    }

    public static void main(String[] args) {

        System.out.println(conStr("hello"," world"));

        //代替内部匿名类
        new Thread(()-> System.out.println("haha")).run();

        //迭代遍历
        List list = new ArrayList<String>(5);
        list.add("SUN");
        list.add("TANG");
        list.add("ZHU");
        list.forEach(x-> System.out.println(x) );

        //lambda 实现map
        List<Double> l2 = Arrays.asList(10.0,20.0,30.0);
        l2.stream().map(x -> x+x*0.5).forEach(x-> System.out.println(x));

        //lambda 实现map reduce
        List<Double> l3 = Arrays.asList(10.0,20.0,15.0,40.0,52.0);
        double total =l3.stream().map(x->x+x*2).reduce((sum,x)->sum + x).get();
        System.out.println(total);
    }
}
