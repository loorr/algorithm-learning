package com.example.common;

public class TestOne implements TemplateCallBack{
    private int a;


    @Override
    public void generateCase() {
        a = 0;
    }

    @Override
    public void run() {
        System.out.println("run resut " + a);
    }
}
