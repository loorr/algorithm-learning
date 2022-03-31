package com.example.common;


import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
public class Main {
    public static final String PACKAGE_PREFIX = "com.example.common.%s";

    public static void main(String[] args) {
        if (args==null || args.length == 0){
            log.info("Enter the classpath you want to run.");
        }
        for (String className: args){
            Date start = new Date();
            log.info("=== {} Program running =======================", className);
            runClass(String.format(PACKAGE_PREFIX, className));
            Date end = new Date();
            log.info("=== {} Program end, It takes {} millisecond ===\n", className, end.getTime()-start.getTime());
        }
    }

    public static void runClass(String className){
        try {
            Class<?> clazz1  = Class.forName(className);
            TemplateCallBack templateCallBack = (TemplateCallBack) clazz1.newInstance();
            new CodeTemplate().process(templateCallBack);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error(e);
            e.printStackTrace();
        }
    }
}
