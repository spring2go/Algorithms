package com.spring2go.algorithms.datastructures.linkedlist;

import java.util.Iterator;

/**
 * Created on Jun, 2020 by @author bobo
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    // INSTANCE VARIABLES HERE

    // 内部节点类
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // 将链表清空，O(n)
    public void clear() {
        // YOUR CODE HERE
    }

    // 返回链表的长度
    public int size() {
        // YOUR CODE HERE
        return 0;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        // YOUR CODE HERE
        return false;
    }

    // 向链表的尾部添加一个元素, O(1)
    public void add(T elem) {
        // YOUR CODE HERE
    }

    // 向链表的尾部添加一个元素, O(1)
    public void addLast(T elem) {
        // YOUR CODE HERE
    }

    // 在链表的开始处添加一个元素，O(1)
    public void addFirst(T elem) {
        // YOUR CODE HERE
    }

    // 向指定的索引位置添加一个元素
    public void addAt(int index, T data) throws Exception {
        // YOUR CODE HERE
    }

    // 获取第一个节点的值，如果存在的话, O(1)
    public T peekFirst() {
        // YOUR CODE HERE
        return null;
    }

    // 获取最后一个节点的值，如果存在的话，O(1)
    public T peekLast() {
        // YOUR CODE HERE
        return null;
    }

    // 移除链表中的头部节点，并返回它的值，O(1)
    public T removeFirst() {
        // YOUR CODE HERE
        return null;
    }

    // 移除链表中的最后一个节点，并返回它的值，O(1)
    public T removeLast() {
        // YOUR CODE HERE
        return null;
    }

    // 从链表中移除一个指定的节点，O(1)
    private T remove(Node<T> node) {
        // YOUR CODE HERE
        return null;
    }

    // 移除指定索引位置的节点，O(n)
    public T removeAt(int index) {
        // YOUR CODE HERE
        return null;
    }

    // 在链表中移除指定的对象, O(n)
    public boolean remove(Object obj) {
        // YOUR CODE HERE
        return false;
    }

    // 查找指定对象在链表中的索引, O(n)
    public int indexOf(Object obj) {
        // YOUR CODE HERE
        return 0;
    }

    // 检查链表中是否包含某个值
    public boolean contains(Object obj) {
        // YOUR CODE HERE
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // YOUR CODE HERE
        return null;
    }


    @Override
    public String toString() {
        // YOUR CODE HERE
        return null;
    }
}
