package cn.javaguide.datastructures.priorityqueue;

public interface Queue<E> {

    /**
     * 获取当前队列大小
     */
    int size();

    /**
     * 判断当前队列是否为空
     */
    boolean isEmpty();

    /**
     * 添加元素到优先队列中
     */
    boolean offer(E e);

    /**
     * 返回优先队列优先级最高的元素,如果队列不存在元素则直接返回空
     */
    E poll();

    /**
     * 查看优先队列堆顶元素,如果队列为空则返回空
     */
    E peek();
}