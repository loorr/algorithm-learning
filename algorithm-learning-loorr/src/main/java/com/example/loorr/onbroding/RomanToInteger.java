package com.example.loorr.onbroding;

import com.example.common.TemplateCallBack;
import junit.framework.Assert;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer [Easy]
 * @author loorr
 * @link https://leetcode.com/problems/roman-to-integer/
 */
@Log4j2
public class RomanToInteger implements TemplateCallBack {

    public Map<Character, Integer> convertNumberMap = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public Map<String, Integer> testCaseMap;


    @Override
    public void generateCase() {
        testCaseMap = new HashMap<String, Integer>(){{
            put("III", 3);
            put( "LVIII", 58);
            put("MCMXCIV", 1994);
        }};
    }

    @Override
    public void run() {
        for (String input: testCaseMap.keySet()){
            int expected = testCaseMap.get(input);
            Assert.assertEquals(expected, romanToInt(input));
        }
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int len = s.length();

        char firstChar = s.charAt(len-1);
        int preValue = convertNumberMap.get(firstChar);
        if (len == 1) {
            return preValue;
        }

        int result = preValue;
        for (int i = len-2; i >=0; i--) {
            int currentValue = convertNumberMap.get(s.charAt(i));
            if (preValue > currentValue){
                result -= currentValue;
            }else {
                result += currentValue;
            }
            preValue = currentValue;
        }
        log.info(s + " " + result);
        return result;
    }
}
