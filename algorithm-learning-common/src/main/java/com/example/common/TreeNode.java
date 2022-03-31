package com.example.common;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    /**
     * 生成二叉树
     * @param data
     * @return
     */
      public static TreeNode getInstance(Integer[] data){
          TreeNode root = null;
          int len = data.length;
          TreeNode[] nodeArr = new TreeNode[len];
          for (int i = 0; i < len; i++) {
              if (data[i] != null){
                  nodeArr[i] = new TreeNode(data[i]);
                  if (i == 0) root = nodeArr[i];
              }
          }
          for (int i = 0; i*2+2<len; i++){
              if (nodeArr[i] != null){
                  nodeArr[i].left = nodeArr[i*2+1];
                  nodeArr[i].right = nodeArr[i*2+2];
              }
          }
          return root;
      }
}
