package datastructures.trees.binarysearchtree;

import java.util.function.Consumer;

public class BinarySearchTree <T extends Comparable<T>> {

    private Node<T> root;

    private static class Node <T extends Comparable<T>> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Provided data cannot be null");
        }
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void delete(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Provided data cannot be null");
        }
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
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

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return contains(node.left, data);
        } else if (cmp > 0) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    public void inorder(Consumer<T> action) {
        inorder(root, action);
    }

    private void inorder(Node<T> node, Consumer<T> action) {
        if (node == null) {
            return;
        }
        inorder(node.left, action);
        action.accept(node.data);
        inorder(node.right, action);
    }

    public void preorder(Consumer<T> action) {
        preorder(root, action);
    }

    private void preorder(Node<T> node, Consumer<T> action) {
        if (node == null) {
            return;
        }
        action.accept(node.data);
        preorder(node.left, action);
        preorder(node.right, action);
    }

    public void postorder(Consumer<T> action) {
        postorder(root, action);
    }

    private void postorder(Node<T> node, Consumer<T> action) {
        if (node == null) {
            return;
        }
        postorder(node.left, action);
        postorder(node.right, action);
        action.accept(node.data);
    }

    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }

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

    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

}
