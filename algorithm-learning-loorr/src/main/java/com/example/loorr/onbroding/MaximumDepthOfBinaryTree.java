package com.example.loorr.onbroding;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import junit.framework.Assert;


/**
 * 104
 * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree implements TemplateCallBack {
    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        TreeNode case1 = TreeNode.getInstance(new Integer[]{3,9,20,null,null,15,7});
        Assert.assertEquals(3, maxDepth(case1));
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
