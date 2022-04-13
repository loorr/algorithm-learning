package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */

public class NaryTreeLevelOrderTraversal implements TemplateCallBack {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            int levelLength = nodeQueue.size();
            List<Integer> levelValue = new LinkedList<>();
            for (int i = 0; i < levelLength; i++){
                Node tempNode = nodeQueue.poll();
                levelValue.add(tempNode.val);
                for (int j = 0; j < tempNode.children.size(); j++){
                    nodeQueue.add(tempNode.children.get(j));
                }
            }
            ans.add(levelValue);
        }
        return ans;
    }

    @Override
    public void generateCase() {
//        无法创建实例
    }

    @Override
    public void run() {

    }
}
