package com.example.loorr.onbroding;

import com.example.common.TemplateCallBack;
import com.example.common.tree.Node;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class NAryTreeLevelOrderTraversal implements TemplateCallBack {
    @Override
    public void generateCase() {

    }

    @Override
    public void run() {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                row.add(node.val);
                for(Node child: node.children){
                    if (child!=null) queue.offer(child);
                }
            }
            result.add(row);
        }
        return result;
    }
}
