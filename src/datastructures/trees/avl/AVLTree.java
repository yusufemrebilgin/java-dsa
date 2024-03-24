package datastructures.trees.avl;

import datastructures.trees.binarysearchtree.BinarySearchTree;


public class AVLTree <T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public void insert(T data) {
        super.insert(data);
        root = balanceAfterInsertion(root, data);
    }

    private Node<T> balanceAfterInsertion(Node<T> node, T data) {

        updateHeight(node);
        int balanceFactor = getBalance(node);

        // Left-Left
        if (balanceFactor > 1 && data.compareTo(node.left.data) < 0)
            return rightRotate(node);

        // Left-Right
        if (balanceFactor > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Right
        if (balanceFactor < -1 && data.compareTo(node.right.data) > 0)
            return leftRotate(node);

        // Right-Left
        if (balanceFactor < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node);
            return leftRotate(node);
        }

        return node;
    }

    @Override
    public void delete(T data) {
        super.delete(data);
        root = balanceForDeletion(root, data);
    }

    private Node<T> balanceForDeletion(Node<T> node, T data) {

        updateHeight(node);
        int balanceFactor = getBalance(node);

        if (balanceFactor > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        if (balanceFactor > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalance(node.right) < 0)
            return leftRotate(node);

        if (balanceFactor < -1 && getBalance(node.right) >= 0) {
            node.right = rightRotate(node);
            return leftRotate(node);
        }

        return node;
    }

    private Node<T> leftRotate(Node<T> node) {
        Node<T> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        updateHeight(node);
        updateHeight(temp);

        return temp;
    }

    private Node<T> rightRotate(Node<T> node) {
        Node<T> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        updateHeight(node);
        updateHeight(temp);

        return temp;
    }

    private int getHeight(Node<T> node) {
        return (node == null) ? -1 : node.height;
    }

    private int getBalance(Node<T> node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private void updateHeight(Node<T> node) {
        if (node != null) {
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

}
