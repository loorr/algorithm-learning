package com.example.common;

import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 从数组构造链表
     * @param nodeArr
     * @return
     */
    public static ListNode getInstance(Integer [] nodeArr){
        ListNode node = new ListNode();
        ListNode root = node;
        for (int i = 0; i < nodeArr.length; i++) {
            ListNode next = new ListNode(nodeArr[i]);
            node.next = next;
            node = next;
        }
        return root.next.next;
    }

    public static ListNode getInstance(List<Integer> list){
        Integer[] arr  = list.toArray(new Integer[list.size()]);
        return getInstance(arr);
    }
}
