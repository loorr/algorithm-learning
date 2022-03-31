package com.example.common;

public class CodeTemplate {
    public CodeTemplate() {
    }

    public void process(TemplateCallBack templateCallBack) {
        try {
            templateCallBack.generateCase();
            templateCallBack.run();
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }
}
