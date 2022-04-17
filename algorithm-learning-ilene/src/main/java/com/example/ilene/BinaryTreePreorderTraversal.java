package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import junit.framework.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal implements TemplateCallBack {
    List<Integer> preList = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return preList;
    }

    public void preorder(TreeNode root){
        if (root == null){
            return;
        }
        preList.add(root.val);
        preorder(root.left);
        preorder(root.right);

    }

    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        TreeNode root1 = TreeNode.getInstance(new Integer[]{1, null, 2, null, null, 3, null});
        TreeNode root2 = TreeNode.getInstance(new Integer[]{});
        TreeNode root3 = TreeNode.getInstance(new Integer[]{1});
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {};
        Integer[] arr3 = {1};
        Assert.assertEquals(Arrays.asList(arr3), preorderTraversal(root3));
    }
}
