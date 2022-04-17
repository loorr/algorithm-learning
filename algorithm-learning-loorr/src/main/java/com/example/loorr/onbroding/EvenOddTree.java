package com.example.loorr.onbroding;

import com.example.common.TemplateCallBack;
import com.example.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1609. Even Odd Tree
 * @link: https://leetcode-cn.com/problems/even-odd-tree/
 */
@Slf4j
public class EvenOddTree implements TemplateCallBack {
    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        TreeNode root = TreeNode.getInstance(new Integer[]{15,184,180,25,29,33,37,126,122,118,114,112,108,106,104,27,29,33,35,37,41,43,null,null,null,null,null,47,49,53,57,null,null,168,null,164,162,158,null,156,null,152,98,null,null,96,92,90,null,88,86,84,null,89,null,91,null,null,null,95,99,null,null,null,null,null,null,101,105,107,111,null,null,null,null,null,null,null,null,null,null,null,null,118,null,114,null,112,110,108,104,100,96,94,null,99,null,103,null,105,107,111,null,null,null,115,null,119,null,91,null,null,null,128,null,124,120,118,null,114,null,null,null,null,null,null,null,null,null,
                75,null,79,null,81,null,null,null,null,null,null,null,null,null,182,null,61});
        log.info("false :{}", isEvenOddTree(root));
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int layer = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int prev = layer %2 == 0 ?  Integer.MIN_VALUE:Integer.MAX_VALUE ;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int curr = node.val;
                if (layer%2== 0){
                    if (node.val %2 == 0 || curr <= prev){
                        return false;
                    }

                }else {
                    if (node.val %2 != 0 || curr >= prev){
                        return false;
                    }
                }
                prev = curr;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            layer ++;
        }
        return true;
    }
}
