package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import junit.framework.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. ��ż��
 * ���һ�ö���������������������������Գ�Ϊ ��ż�� ��
 * ���������ڵ����ڲ��±�Ϊ 0 �������ӽڵ����ڲ��±�Ϊ 1 ��������ڵ����ڲ��±�Ϊ 2 ���������ơ�
 * ż���±� ���ϵ����нڵ��ֵ���� �� �����������Ұ�˳�� �ϸ����
 * �����±� ���ϵ����нڵ��ֵ���� ż �����������Ұ�˳�� �ϸ�ݼ�
 * ����������ĸ��ڵ㣬���������Ϊ ��ż�� ���򷵻� true �����򷵻� false ��
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
            // ż����������ڵ�ֵΪ����
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
            }else { // ������ݼ����ڵ�ֵΪż��
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
