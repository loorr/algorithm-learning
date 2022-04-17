package com.example.common;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import java.util.List;

public class AssertUtil {

    public static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    public static <T> void assertArrayEquals(List<T> expected, List<T> actual) {
        if (expected == null && actual == null) {
            return;
        }
        Assert.assertEquals(expected.size(), actual.size());
        int index = -1;
        for (int i = 0; i < expected.size(); i++) {
            T expectedValue = expected.get(i);
            T actualValue = actual.get(i);
            if (expectedValue == null && actualValue == null){
                continue;
            }
            if (expectedValue == null || actualValue == null){
                index = i;
                break;
            }
            if (!expectedValue.equals(actualValue)){
                index = i;
                break;
            }
        }
        if (-1 != index){
            fail("not equal, expected: " + expected.get(index) + " but actual: " + actual.get(index));
        }

    }

    public static void assertArrayEquals(Integer[] expected, Integer[] actual) {
        int expectedSize = expected.length;
        int actualSize = actual.length;
        Assert.assertEquals(expectedSize, actualSize);

        int index = -1;
        for (int i = 0; i < expectedSize; i++) {
            if (expected[i] == null && actual[i] == null) {
                continue;
            }
            if (expected[i] == null || actual[i] == null) {
                index = i;
                break;
            }
            if (!expected[i].equals(actual[i])){
                index = i;
                break;
            }
        }
        if (-1 != index){
            fail("not equal, expected: " + expected[index] + " but actual: " + actual[index]);
        }
    }
}
