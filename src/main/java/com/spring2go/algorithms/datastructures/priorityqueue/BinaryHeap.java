package com.spring2go.algorithms.datastructures.priorityqueue;

import java.util.*;

/**
 * 基于ArrayList方式实现的二叉堆，使用HashMap优化移除Removal操作.
 *
 * 用你的实现代码替换TODO YOUR CODE HERE.
 *
 * Created on Jun, 2020 by @author bobo
 */
public class BinaryHeap<T extends Comparable> {
    private List<T> heapList = null;

    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    // 构造和初始化一个空的优先队列
    public BinaryHeap() {
        this(1);
    }

    // 构造一个具有初始容量的优先队列
    public BinaryHeap(int size) {
        this.heapList = new ArrayList<>(size);
    }

    // 构建一个优先队列，O(n)复杂度，算法解释请参考：
    // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
    public BinaryHeap(T[] elems) {
        this(elems.length);

        int heapSize = elems.length;

        for(int i = 0; i < heapSize; i++) {
            mapAdd(elems[i], i);
            heapList.add(elems[i]);
        }

        for (int i = Math.max(0, (heapSize / 2 ) - 1 ); i >= 0; i--) sink(i);
    }

    // 构建一个优先队列，O(nlog(n))
    public BinaryHeap(Collection<T> elems) {
        this(elems.size());

        for (T elem : elems) {
            add(elem);
        }
    }

    // 检查优先队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 清除堆内部状态数据，O(n)
    public void clear() {
        heapList.clear();
        map.clear();
    }

    // 返回堆的大小
    public int size() {
        return heapList.size();
    }

    // 查看优先队列中最大优先级(最小值)的元素，不移除，O(1)。
    // 如果优先队列为空，则返回null。
    public T peek() {
        if (isEmpty()) return null;
        return heapList.get(0);
    }

    // 移除堆顶元素，O(log(n))
    public T poll() {
        return removeAt(0);
    }

    // 检查某个元素在堆中是否存在，O(1)
    public boolean contains(T elem) {
        if (elem == null) return false;
        return map.containsKey(elem);
    }

    // 向优先队列中添加一个元素，元素不能是null，O(log(n))。
    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();

        heapList.add(elem);
        int indexOfLastElem = size() - 1;
        mapAdd(elem, indexOfLastElem);

        swim(indexOfLastElem);
    }

    // 检查节点i的值是否小于节点j的值
    // 该方法假定i和j是合法的索引，O(1)
    private boolean less(int i, int j) {
        T elem_i = heapList.get(i);
        T elem_j = heapList.get(j);

        return elem_i.compareTo(elem_j) <= 0;
    }

    // 执行节点上浮操作
    private void swim(int k) {
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;

            parent = (k - 1) / 2;
        }
    }

    // 执行节点下沉操作，O(log(n))
    private void sink(int k) {
        int heapSize = size();

        while(true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) smallest = right;

            if (left >= heapSize || less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }
    }

    // 交换两个节点。假定i和j是合法的索引，O(1)
    private void swap(int i, int j) {
        T elem_i = heapList.get(i);
        T elem_j = heapList.get(j);

        heapList.set(i, elem_j);
        heapList.set(j, elem_i);

        mapSwap(elem_i, elem_j, i, j);
    }

    // 移除堆中的某个特定元素，O(log(n))
    public boolean remove(T element) {
        if (element == null) return false;

        Integer index = mapGet(element);
        if (index != null) removeAt(index);

        return index != null;
    }

    // 移除某个特定索引位置的节点，O(log(n))
    private T removeAt(int i) {
        if (isEmpty()) return null;

        int indexOfLastElem = size() - 1;
        T removed_data = heapList.get(i);
        swap(i, indexOfLastElem);

        heapList.remove(indexOfLastElem);
        mapRemove(removed_data, indexOfLastElem);

        if (i == indexOfLastElem) return removed_data;

        T elem = heapList.get(i);

        sink(i);

        if (heapList.get(i).equals(elem)) swim(i);

        return removed_data;
    }

    // 递归检查堆是否是最小堆，该方法仅用于测试。
    // 输入 k=0 表示从根节点开始调用该方法。
    public boolean isMinHeap(int k) {
        int heapSize = size();

        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    // 将节点值和它的索引添加到Map中
    private void mapAdd(T value, int index) {
        TreeSet<Integer> set = map.get(value);

        if (set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
        } else {
            set.add(index);
        }
    }

    // 给定一个节点的值，移除它的索引，O(log(n))
    private void mapRemove(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        if (set == null) throw new NullPointerException();
        set.remove(index);
        if (set.isEmpty()) map.remove(value);
    }

    // 给定一个节点的值，取出它的索引位置
    // 注意：如果节点值在堆中重复存在，那么可以取最大的那个索引(这个是任意选择的)
    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        if (set == null) return null;
        return set.last();
    }

    // 交换两个节点在Map中的索引
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {
        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }

    @Override
    public String toString() {
        return heapList.toString();
    }
}
