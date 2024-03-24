package datastructures.trees.binarysearchtree;

import datastructures.trees.AbstractBinaryTree;

public class BinarySearchTree <T extends Comparable<T>> extends AbstractBinaryTree<T> {

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Provided data cannot be null");
        }
        root = insert(root, data);
    }

    protected Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        } else {
            int comparison = data.compareTo(node.data);
            if (comparison < 0) {
                node.left = insert(node.left, data);
            } else if (comparison > 0) {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    @Override
    public void delete(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Provided data cannot be null");
        }
        root = delete(root, data);
    }

    protected Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = delete(node.left, data);
        else if (cmp > 0)
            node.right = delete(node.right, data);
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node<T> temp = findMinNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }
        return node;
    }

    @Override
    public T findMin() {
        Node<T> minNode = findMinNode(root);
        return (minNode != null) ? minNode.data : null;
    }

    private Node<T> findMinNode(Node<T> node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public T findMax() {
        Node<T> maxNode = findNaxNode(root);
        return (maxNode != null) ? maxNode.data : null;
    }

    private Node<T> findNaxNode(Node<T> node) {
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        int comparison = data.compareTo(node.data);
        if (comparison < 0) {
            return contains(node.left, data);
        } else if (comparison > 0) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public void clear() {
        root = null;
    }

}
