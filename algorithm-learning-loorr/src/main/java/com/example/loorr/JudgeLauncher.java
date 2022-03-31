package com.example.loorr;

import com.example.common.CodeTemplate;
import com.example.common.TemplateCallBack;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JudgeLauncher {
    public static final String PACKAGE_PREFIX = "com.example.loorr.%s";

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
            log.error(String.valueOf(e));
            e.printStackTrace();
        }
    }
}
