package datastructures.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Heap <T extends Comparable<T>> {

    private final HeapType type;
    private final List<T> heap;
    private final int capacity;

    private static final int FRONT = 0;

    public Heap(int capacity, HeapType type) {
        this.type = type;
        this.capacity = capacity;
        heap = new ArrayList<>(capacity);
    }

    public void insert(T value) {
        if (isFull()) {
            throw new IllegalArgumentException("Heap is full");
        }
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T delete() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is empty");
        }
        T deletedValue = heap.get(FRONT);
        heap.set(FRONT, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(FRONT);

        return deletedValue;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is empty");
        }
        return heap.get(FRONT);
    }

    private void heapifyUp(int index) {
        int parentIndex = getParent(index);
        while (index > 0 && compare(heap.get(index), heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int comparedIndex = index;
        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);

        int heapSize = heap.size();
        if (leftChildIndex < heapSize && compare(heap.get(leftChildIndex), heap.get(comparedIndex)) < 0) {
            comparedIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && compare(heap.get(rightChildIndex), heap.get(comparedIndex)) < 0) {
            comparedIndex = rightChildIndex;
        }
        if (comparedIndex != index) {
            swap(index, comparedIndex);
            heapifyDown(comparedIndex);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean isFull() {
        return capacity == heap.size();
    }

    public int size() {
        return heap.size();
    }

    public boolean contains(T value) {
        return heap.contains(value);
    }

    public Stream<T> stream() {
        return heap.stream();
    }

    public void clear() {
        heap.clear();
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int compare(T a, T b) {
        return (type == HeapType.MIN_HEAP) ? a.compareTo(b) : b.compareTo(a);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

}
