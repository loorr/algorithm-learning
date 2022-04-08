package com.example.loorr.onbroding;

import com.example.common.AssertUtil;
import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * @link https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal implements TemplateCallBack {


    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        TreeNode root = TreeNode.getInstance(new Integer[]{1, null, 2, null, null, 3, null});
        List<Integer> ans = preorderTraversal(root);
        Integer[] array = {1,2,3};
        AssertUtil.assertArrayEquals(Arrays.asList(array), ans);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }


    public void preorderTraversal(TreeNode root, List<Integer> result ) {
       if (root == null){
           return;
       }
       result.add(root.val);
       if (root.left != null){
           preorderTraversal(root.left, result);
       }
       if (root.right != null){
           preorderTraversal(root.right, result);
       }
    }
}
