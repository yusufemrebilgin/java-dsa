package datastructures.trees;

import java.util.function.Consumer;

public interface BinaryTree<T> {

    void insert(T data);
    void delete(T data);
    boolean contains(T data);
    boolean isEmpty();
    int size();
    int height();
    T findMin();
    T findMax();
    void traverse(TraversalOrder traversalOrder, Consumer<T> action);
    void clear();

}
