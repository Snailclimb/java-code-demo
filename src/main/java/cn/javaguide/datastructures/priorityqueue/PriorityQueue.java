package cn.javaguide.datastructures.priorityqueue;

import java.util.Comparator;

/**
 * 微信搜 JavaGuide 回复"面试突击"即可免费领取个人原创的 Java 面试手册
 *
 * @author Guide哥
 * @date 2023/07/01 08:49
 **/
public class PriorityQueue<E extends Comparable> implements Queue<E> {

    private final MinHeap<E> data;


    public PriorityQueue() {
        data = new MinHeap<>();
    }

    public PriorityQueue(Comparator comparator) {
        data = new MinHeap<>(comparator);
    }


    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean offer(E e) {
        data.add(e);
        return true;
    }

    @Override
    public E poll() {
        return data.poll();
    }

    @Override
    public E peek() {
        return data.peek();
    }
}