package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import junit.framework.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. 奇偶树
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 */

public class EvenOddTree implements TemplateCallBack {


    public boolean isEvenOddTree(TreeNode root) {
        if (root == null){
            return true;
        }
        int noLevel = 0;
        Queue<TreeNode> levelNode = new LinkedList<>();
        levelNode.add(root);
        int curValue;
        while (!levelNode.isEmpty()){
            int levelSize = levelNode.size();
            // 偶数层递增，节点值为奇数
            if (noLevel%2 == 0){
                curValue = Integer.MIN_VALUE;
                for (int i = 0; i < levelSize; i++){
                    TreeNode curNode = levelNode.poll();
                    if (curNode.val > curValue && curNode.val % 2 != 0) {
                        curValue = curNode.val;
                        if (curNode.left != null){
                            levelNode.add(curNode.left);
                        }
                        if (curNode.right != null){
                            levelNode.add(curNode.right);
                        }
                    }else {
                        return false;
                    }

                }
            }else { // 奇数层递减，节点值为偶数
                curValue = Integer.MAX_VALUE;
                for (int i = 0; i < levelSize; i++){
                    TreeNode curNode = levelNode.poll();
                    if (curNode.val < curValue && curNode.val % 2 == 0){
                        curValue = curNode.val;
                        if (curNode.left != null){
                            levelNode.add(curNode.left);
                        }
                        if (curNode.right != null){
                            levelNode.add(curNode.right);
                        }
                    }else {
                        return false;
                    }
                }
            }
            noLevel++;
        }
        return true;
    }

    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        Integer[] case1 = new Integer[]{5, 9 , 1, 3, 5, 7};
        TreeNode root1 = TreeNode.getInstance(case1);
        Assert.assertEquals(false, isEvenOddTree(root1));
    }
}
