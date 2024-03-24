package datastructures.trees;

import java.util.function.Consumer;

public abstract class AbstractBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    protected Node<T> root;

    protected static class Node<T extends Comparable<T>> {
        public int height;
        public T data;
        public Node<T> left, right;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void traverse(TraversalOrder traversalOrder, Consumer<T> action) {
        switch (traversalOrder) {
            case INORDER -> inorderTraversal(root, action);
            case PREORDER -> preorderTraversal(root, action);
            case POSTORDER -> postorderTraversal(root, action);
        }
    }

    private void inorderTraversal(Node<T> node, Consumer<T> action) {
        if (node != null) {
            inorderTraversal(node.left, action);
            action.accept(node.data);
            inorderTraversal(node.right, action);
        }
    }

    private void preorderTraversal(Node<T> node, Consumer<T> action) {
        if (node != null) {
            action.accept(node.data);
            preorderTraversal(node.left, action);
            preorderTraversal(node.right, action);
        }
    }

    private void postorderTraversal(Node<T> node, Consumer<T> action) {
        if (node != null) {
            postorderTraversal(node.left, action);
            postorderTraversal(node.right, action);
            action.accept(node.data);
        }
    }

}
