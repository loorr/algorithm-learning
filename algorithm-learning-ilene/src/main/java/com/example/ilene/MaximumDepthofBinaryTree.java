package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;

/**
 * 104. Maximum Depth of Binary Tree
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
@Slf4j
public class MaximumDepthofBinaryTree implements TemplateCallBack {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left  == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        Integer[] case1 = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.getInstance(case1);
        int a = maxDepth(root);
        Assert.assertEquals(3, a);

        Integer[] case2 = new Integer[]{1,null,2};
        TreeNode root2 = TreeNode.getInstance(case2);
        Assert.assertEquals(2, maxDepth(root2));
    }
}
