package com.spring2go.algorithms.datastructures.binarysearchtree;

import java.util.ConcurrentModificationException;

/**
 * 二叉搜索树(BST)实现。
 *
 * Created on Jul, 2020 by @author bobo
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private int nodeCount = 0;

    private Node root = null;

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
        return size() == 0;
    }

    // 获取二叉搜索树中节点的数量
    public int size() {
        return nodeCount;
    }

    // 向二叉搜索树中添加一个元素，如果成功执行添加就返回true
    public boolean add(T elem) {
        if (contains(root, elem)) {
            return false;
        } else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    // 私有方法，在二叉搜索树中递归添加一个值
    private Node add(Node node, T elem) {
        Node temp = node;

        if (node == null) {
            temp = new Node(null, null, elem);
        } else {
            int cmp = elem.compareTo(node.data);

            if (cmp < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }

        return temp;
    }

    // 从二叉搜索树中移除一个值，如果存在的话，复杂度：O(n)
    public boolean remove(T elem) {
        if (contains(root, elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {
        if (node == null) return null;

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) { // 情况1/2
                Node rightChild = node.right;

                node.data = null;
                node = null;

                return rightChild;
            } else if (node.right == null) { // 情况3
                Node leftChild = node.left;

                node.data = null;
                node = null;

                return leftChild;
            } else { // 情况4
                Node tmp = findMin(node.right);

                node.data = tmp.data;

                node.right = remove(node.right, tmp.data);
            }
        }

        return node;
    }

    // 助手方法，查找最左节点(值最小)
    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // 助手方法，查找最右节点(值最大)
    private Node findMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // 如果元素存在于树中，就返回true，否则返回false
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    // 私有递归方法，在二叉搜索树中寻找一个元素
    private boolean contains(Node node, T elem) {
        if (node == null) return false;

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) {
            return contains(node.left, elem);
        } else if (cmp > 0) {
            return contains(node.right, elem);
        }

        return true;
    }

    // 计算树的高度，O(n)
    public int height() {
        return height(root);
    }

    // 计算树的高度的递归助手方法
    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
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
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // 返回中序遍历一棵树的迭代器
    private java.util.Iterator<T> inOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>() {

            Node trav = root;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();

                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }

                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // 返回后序遍历一棵树的迭代器
    private java.util.Iterator<T> postOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack1 = new java.util.Stack<>();
        final java.util.Stack<Node> stack2 = new java.util.Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            if (node != null) {
                stack2.push(node);
                if (node.left != null) stack1.push(node.left);
                if (node.right != null) stack1.push(node.right);
            }
        }

        return new java.util.Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return stack2.pop().data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }

    // 返回按层次遍历一棵树的迭代器
    private java.util.Iterator<T> levelOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        return new java.util.Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

