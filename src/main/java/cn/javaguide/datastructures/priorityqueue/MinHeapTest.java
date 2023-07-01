package cn.javaguide.datastructures.priorityqueue;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class MinHeapTest {
    public static void main(String[] args) {

        int n = 1000_0000;

        MinHeap<Integer> heap = new MinHeap<>(n, Comparator.comparingInt(a -> a));

        //往堆中随机存放1000w个元素
        for (int i = 0; i < n; i++) {
            heap.add(ThreadLocalRandom.current().nextInt(0, n));
        }

        int[] arr = new int[n];

        //进行出队操作，并将元素存到数组中
        for (int i = 0; i < n; i++) {
            arr[i] = heap.poll();
        }

        //循环遍历，如果前一个元素比后一个元素大，则说明我们的小顶堆有问题
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new RuntimeException("err heap");
            }
        }
    }
}