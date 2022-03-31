package com.example.loorr.onbroding;

import com.example.common.TemplateCallBack;
import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum [Easy]
 * @author loorr
 * @link https://leetcode.com/problems/two-sum/
 */
public class TwoSum implements TemplateCallBack {


    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        int[] testCaseNums1 = new int[]{2,7,11,15};
        int testCaseTarget1 = 9;
        int[] expected1 = new int[]{0,1};
        int[] result1 = twoSum(testCaseNums1, testCaseTarget1);
        for (int i = 0; i < expected1.length; i++){
            Assert.assertEquals(expected1[i], result1[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (elementIndexMap.containsKey(key)){
                return new int[]{elementIndexMap.get(key), i};
            }
            elementIndexMap.put(target - nums[i], i);
        }
        return new int[2];
    }


}
