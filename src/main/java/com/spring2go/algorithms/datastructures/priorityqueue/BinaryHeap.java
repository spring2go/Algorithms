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

    // TODO YOUR CODE HERE
    // INSTANCE VARIABLES

    // 构造和初始化一个空的优先队列
    public BinaryHeap() {
        // TODO YOUR CODE HERE
    }

    // 构造一个具有初始容量的优先队列
    public BinaryHeap(int size) {
        // TODO YOUR CODE HERE
    }

    // 构建一个优先队列，O(n)复杂度，算法解释请参考：
    // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
    public BinaryHeap(T[] elems) {
        // TODO YOUR CODE HERE
    }

    // 构建一个优先队列，O(nlog(n))
    public BinaryHeap(Collection<T> elems) {
        // TODO YOUR CODE HERE
    }

    // 检查优先队列是否为空
    public boolean isEmpty() {
        // TODO YOUR CODE HERE
        return false;
    }

    // 清除堆内部状态数据，O(n)
    public void clear() {
        // TODO YOUR CODE HERE
    }

    // 返回堆的大小
    public int size() {
        // TODO YOUR CODE HERE
        return 0;
    }

    // 查看优先队列中最大优先级(最小值)的元素，不移除，O(1)。
    // 如果优先队列为空，则返回null。
    public T peek() {
        // TODO YOUR CODE HERE
        return null;
    }

    // 移除堆顶元素，O(log(n))
    public T poll() {
        // TODO YOUR CODE HERE
        return null;
    }

    // 检查某个元素在堆中是否存在，O(1)
    public boolean contains(T elem) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 向优先队列中添加一个元素，元素不能是null，O(log(n))。
    public void add(T elem) {
        // TODO YOUR CODE HERE
    }

    // 检查节点i的值是否小于节点j的值
    // 该方法假定i和j是合法的索引，O(1)
    private boolean less(int i, int j) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 执行节点上浮操作
    private void swim(int k) {
        // TODO YOUR CODE HERE
    }

    // 执行节点下沉操作，O(log(n))
    private void sink(int k) {
        // TODO YOUR CODE HERE
    }

    // 交换两个节点。假定i和j是合法的索引，O(1)
    private void swap(int i, int j) {
        // TODO YOUR CODE HERE
    }

    // 移除堆中的某个特定元素，O(log(n))
    public boolean remove(T element) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 移除某个特定索引位置的节点，O(log(n))
    private T removeAt(int i) {
        // TODO YOUR CODE HERE
        return null;
    }

    // 递归检查堆是否是最小堆，该方法仅用于测试。
    // 输入 k=0 表示从根节点开始调用该方法。
    public boolean isMinHeap(int k) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 将节点值和它的索引添加到Map中
    private void mapAdd(T value, int index) {
        // TODO YOUR CODE HERE
    }

    // 给定一个节点的值，移除它的索引，O(log(n))
    private void mapRemove(T value, int index) {
        // TODO YOUR CODE HERE
    }

    // 给定一个节点的值，取出它的索引位置
    // 注意：如果节点值在堆中重复存在，那么可以取最大的那个索引(这个是任意选择的)
    private Integer mapGet(T value) {
        // TODO YOUR CODE HERE
        return null;
    }

    // 交换两个节点在Map中的索引
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {
        // TODO YOUR CODE HERE
    }

    @Override
    public String toString() {
        // TODO YOUR CODE HERE
        return null;
    }
}
