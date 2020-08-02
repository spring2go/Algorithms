package com.spring2go.algorithms.datastructures.binarysearchtree;

/**
 * 二叉搜索树(BST)实现。
 *
 * Created on Jul, 2020 by @author bobo
 */
public class BinarySearchTree<T extends Comparable<T>> {
    // TODO YOUR INSTANCE VARIABLES HERE

    // 内部节点定义，包含数据和引用
    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    // 检查二叉搜索树是否为空
    public boolean isEmpty() {
        // TODO YOUR CODE HERE
        return false;
    }

    // 获取二叉搜索树中节点的数量
    public int size() {
        // TODO YOUR CODE HERE
        return 0;
    }

    // 向二叉搜索树中添加一个元素，如果成功执行添加就返回true
    public boolean add(T elem) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 私有方法，在二叉搜索树中递归添加一个元素
    private Node add(Node node, T elem) {
        // TODO YOUR CODE HERE
        return null;
    }

    // 从二叉搜索树中移除一个元素，如果存在的话，复杂度：O(n)
    public boolean remove(T elem) {
        // TODO YOUR CODE HERE
        return false;
    }

    private Node remove(Node node, T elem) {
        // TODO YOUR CODE HERE
        return null;
    }

    // 助手方法，查找最左节点(值最小)
    private Node findMin(Node node) {
        // TODO YOUR CODE HERE
        return null;
    }

    // 助手方法，查找最右节点(值最大)
    private Node findMax(Node node) {
        // TODO YOUR CODE HERE
        return null;
    }

    // 如果元素存在于树中，就返回true，否则返回false
    public boolean contains(T elem) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 私有递归方法，在树中寻找一个元素
    private boolean contains(Node node, T elem) {
        // TODO YOUR CODE HERE
        return false;
    }

    // 计算树的高度，O(n)
    public int height() {
        // TODO YOUR CODE HERE
        return 0;
    }

    // 计算树的高度的递归助手方法
    private int height(Node node) {
        // TODO YOUR CODE HERE
        return 0;
    }

    // 返回特定遍历顺序的的迭代器，
    // 支持先序(preorder)，中序(inorder)，后序(postorder)和按层次遍历(levelorder)
    public java.util.Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }


    // 返回先序遍历一棵树的迭代器
    private java.util.Iterator<T> preOrderTraversal() {
        // TODO YOUR CODE HERE
        return null;
    }

    // 返回中序遍历一棵树的迭代器
    private java.util.Iterator<T> inOrderTraversal() {
        // TODO YOUR CODE HERE
        return null;
    }

    // 返回后序遍历一棵树的迭代器
    private java.util.Iterator<T> postOrderTraversal() {
        // TODO YOUR CODE HERE
        return null;
    }

    // 返回按层次遍历一棵树的迭代器
    private java.util.Iterator<T> levelOrderTraversal() {
        // TODO YOUR CODE HERE
        return null;
    }
}

