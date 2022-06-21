package com.example.loorr.heap;

import com.example.common.TemplateCallBack;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach implements TemplateCallBack {


    @Override
    public void generateCase() {

    }

    @Override
    public void run() {
        int[] heights = new int[]{4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        int ans = furthestBuilding(heights, bricks, ladders);
        System.out.println(ans);

        int[] heights1 = new int[]{14,3,19,3};
        int bricks1 = 17;
        int ladders1 = 0;
        int ans2 = furthestBuilding(heights1, bricks1, ladders1);
        System.out.println(ans2);
    }

    /**
     * 使用堆存储遍历过的楼， 如果砖块不够用，选取缺砖最多的用楼梯替换
     * @param heights 建筑物的高度
     * @param bricks 砖块
     * @param ladders 梯子
     * @return 可以到达的最远建筑物的下标（下标 从 0 开始 ）
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length <=1){
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 1; i < heights.length; i++){
            int diff = heights[i] - heights[i-1];
            if (diff <= 0){
                continue;
            }
            bricks -= diff;
            heap.offer(diff);
            if (bricks >= 0){
                continue;
            }
            if (ladders > 0){
                ladders --;
                int num = heap.poll();
                bricks = bricks + num;
                if (bricks < 0){
                   return i-1;
               }
                continue;
            }
            return  i-1;
        }
        return heights.length -1;
    }
}
