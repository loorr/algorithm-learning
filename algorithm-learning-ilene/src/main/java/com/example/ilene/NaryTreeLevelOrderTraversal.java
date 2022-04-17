package com.example.ilene;

import com.example.common.TemplateCallBack;
import com.example.common.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N �����Ĳ������
 * ����һ�� N ������������ڵ�ֵ�Ĳ�����������������ң�����������
 * �������л��������ò��������ÿ���ӽڵ㶼�� null ֵ�ָ����μ�ʾ������
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
//        �޷�����ʵ��
    }

    @Override
    public void run() {

    }
}
