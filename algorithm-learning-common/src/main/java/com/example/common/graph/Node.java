package com.example.common.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图节点
 * @link https://leetcode-cn.com/problems/clone-graph/
 */
public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}