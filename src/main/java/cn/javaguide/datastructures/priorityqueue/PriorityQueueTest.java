package cn.javaguide.datastructures.priorityqueue;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 微信搜 JavaGuide 回复"面试突击"即可免费领取个人原创的 Java 面试手册
 *
 * @author Guide哥
 * @date 2023/07/01 08:50
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        //往队列中随机添加1000_0000条数据
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int n = 1000_0000;
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(ThreadLocalRandom.current().nextInt(1, n));
        }

        //将优先队列中的数据按照优先级取出并存到数组中
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = priorityQueue.poll();
        }

        //如果前一个元素大于后一个元素,则说明优先队列优先级排列有问题
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new RuntimeException("error PriorityQueue");
            }
        }

    }
}
