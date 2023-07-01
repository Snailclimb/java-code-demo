package cn.javaguide.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 元素是可比较的小顶堆
 */
public class MinHeap<E> {

    private List<E> list;


    private Comparator<E> comparator;


    /**
     * 创建一个空的最小堆
     */
    public MinHeap() {
        list = new ArrayList<>();
    }

    /**
     * 创建一个空的最小堆，并指定比较器来决定元素之间的顺序
     */
    public MinHeap(Comparator<E> comparator) {
        list = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * 参数为数组，将给定的数组转换为一个最小堆
     */
    public MinHeap(E[] arr) {
        list = new ArrayList<>(Arrays.asList(arr));
        heapify();
    }

    /**
     * 创建指定容量的最小堆
     */
    public MinHeap(int capacity) {
        list = new ArrayList<>(capacity);
    }


    /**
     * 创建指定容量的最小堆并指定比较器
     */
    public MinHeap(int capacity, Comparator<E> comparator) {
        list = new ArrayList<>(capacity);
        this.comparator = comparator;
    }


    /**
     * 返回堆中元素个数
     */
    public int size() {
        return list.size();
    }

    /**
     * 判断堆元素是否为空
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }


    /**
     * 获取当前节点的父节点索引
     */
    private int parentIndex(int childIndex) {
        if (childIndex == 0) {
            throw new IllegalArgumentException();
        }

        return (childIndex - 1) / 2;
    }

    /**
     * 返回当前节点的左子节点
     */
    private int leftIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回当前节点的右子节点
     */
    private int rightIndex(int index) {
        return 2 * index + 2;
    }


    /**
     * 将元素存到小顶堆中
     */
    public void add(E e) {
        list.add(e);
        siftUp(list.size() - 1);
    }

    /**
     * 为了保证新增节点后，数组仍符合小顶堆特性，这里需要siftUp保持一下平衡
     */
    private void siftUp(int index) {
        if (comparator != null) {
            //循环自新增节点开始自底向上比较子节点和父节点大小，如果子节点大于父节点则交换两者的值
            while (index > 0 && comparator.compare(list.get(parentIndex(index)), list.get(index)) > 0) {
                E tmpElement = list.get(index);
                list.set(index, list.get(parentIndex(index)));
                list.set(parentIndex(index), tmpElement);
                index = parentIndex(index);
            }
        } else {
            //循环自新增节点开始自底向上比较子节点和父节点大小，如果子节点大于父节点则交换两者的值
            while (index > 0 && ((Comparable) list.get(parentIndex(index))).compareTo(list.get(index)) > 0) {
                E tmpElement = list.get(index);
                list.set(index, list.get(parentIndex(index)));
                list.set(parentIndex(index), tmpElement);
                index = parentIndex(index);
            }
        }
    }

    /**
     * 获取小顶堆堆顶的元素
     */
    public E poll() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        E ret = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        siftDown(0);
        return ret;
    }

    /**
     * 将数组转为堆
     */
    private void heapify() {
        //找到最后一个非叶子节点,往前遍历
        for (int i = parentIndex(list.size() - 1); i >= 0; i--) {
            //对每个非叶子节点执行siftDown,使其范围内保持小顶堆特性
            siftDown(i);
        }
    }

    private void siftDown(int index) {

        if (comparator != null) {
            //如果左节点小于数组大小才进入循环，避免数组越界
            while (leftIndex(index) < list.size()) {
                //获取左索引
                int cmpIdx = leftIndex(index);

                //获取左或者右子节点中值更小的索引
                if (rightIndex(index) < list.size() &&
                        comparator.compare(list.get(leftIndex(index)), list.get(rightIndex(index))) > 0) {
                    cmpIdx = rightIndex(index);
                }

                //如果父节点比子节点小则停止比较，结束循环
                if (comparator.compare(list.get(index), list.get(cmpIdx)) <= 0) {
                    break;
                }

                //反之交换位置，将index更新为交换后的索引index，进入下一个循环
                E tmpElement = list.get(cmpIdx);
                list.set(cmpIdx, list.get(index));
                list.set(index, tmpElement);


                index = cmpIdx;

            }
        } else {
            //如果左节点小于数组大小才进入循环，避免数组越界
            while (leftIndex(index) < list.size()) {
                //获取左索引
                int cmpIdx = leftIndex(index);

                //获取左或者右子节点中值更小的索引
                if (rightIndex(index) < list.size() &&
                        ((Comparable) list.get(leftIndex(index))).compareTo(list.get(rightIndex(index))) > 0) {
                    cmpIdx = rightIndex(index);
                }

                //如果父节点比子节点小则停止比较，结束循环
                if (((Comparable) list.get(index)).compareTo(list.get(cmpIdx)) <= 0) {
                    break;
                }

                //反之交换位置，将index更新为交换后的索引index，进入下一个循环
                E tmpElement = list.get(cmpIdx);
                list.set(cmpIdx, list.get(index));
                list.set(index, tmpElement);
                index = cmpIdx;

            }
        }


    }


    public E peek() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}

