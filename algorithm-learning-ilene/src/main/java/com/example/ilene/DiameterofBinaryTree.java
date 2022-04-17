package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import junit.framework.Assert;


/**
 * 543. ��������ֱ��
 * ����һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣
 */
@Slf4j
public class DiameterofBinaryTree implements TemplateCallBack {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        sideDepth(root);
        return ans;
    }

    public int sideDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftDepth = sideDepth(root.left);
        int rightDepth = sideDepth(root.right);
        ans = Math.max(ans, leftDepth+rightDepth);
        return  Math.max(leftDepth, rightDepth)+1;

    }
    TreeNode root1;
    @Override
    public void generateCase() {
        Integer[] case1 = new Integer[]{1, 2, 3, 4, 5};
        root1 = TreeNode.getInstance(case1);
    }

    @Override
    public void run() {
        Assert.assertEquals(3, sideDepth(root1));
    }
}
