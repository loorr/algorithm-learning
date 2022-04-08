package com.example.loorr.onbroding;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;

/**
 * 543. 二叉树的直径
 * @link https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree implements TemplateCallBack {

    @Override
    public void generateCase() {

    }

    @Override
    public void run() {

    }

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans-1;
    }


    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        ans = Math.max(ans, 1 + l + r);
        return Math.max(l, r) + 1;
    }
}
