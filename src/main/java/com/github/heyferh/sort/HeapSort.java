package com.github.heyferh.sort;

/**
 * Created by feku on 9/16/2015.
 */
public class HeapSort {
  private static int HEAP_SIZE;
  private static int[] array;

  public static void main(String[] args) {
    array = new int[]{3, 2, 4, 0, -4, 5};
    buildMaxHeap();
    heapInsert(3);
    System.out.println(extractMax());
  }

  public static void sort(int[] input) {
    array = input;
    buildMaxHeap();
    for (int i = array.length - 1; i >= 1; i--) {
      swap(0, i);
      HEAP_SIZE--;
      maxHeapify(0);
    }
  }

  private static void buildMaxHeap() {
    HEAP_SIZE = array.length;
    for (int i = (array.length / 2) - 1; i >= 0; i--) {
      maxHeapify(i);
    }
  }

  private static void maxHeapify(int i) {
    int l = getLeft(i);
    int r = getRight(i);
    int largest;
    if (l < HEAP_SIZE && array[l] > array[i]) {
      largest = l;
    } else {
      largest = i;
    }
    if (r < HEAP_SIZE && array[r] > array[largest]) {
      largest = r;
    }
    if (largest != i) {
      swap(largest, i);
      maxHeapify(largest);
    }
  }

  private static int getParent(int i) {
    return (i - 1) / 2;
  }

  private static int getLeft(int i) {
    return 2 * i + 1;
  }

  private static int getRight(int i) {
    return 2 * i + 2;
  }

  private static void swap(int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  private static int getMax() {
    return array[0];
  }

  private static int extractMax() {
    if (HEAP_SIZE < 1) {
      throw new IllegalStateException("Empty heap");
    }
    int max = array[0];
    array[0] = array[HEAP_SIZE - 1] - 2;
    maxHeapify(0);
    return max;
  }

  private static void increaseKey(int i, int key) {
    if (key < array[i]) {
      throw new IllegalArgumentException("New key mustn't be less than the previous one");
    }
    array[i] = key;
    while (i > 0 && array[getParent(i)] < array[i]) {
      swap(i, getParent(i));
      i = getParent(i);
    }
  }

  private static void heapInsert(int key) {
    int[] newArray = new int[array.length + 1];
    System.arraycopy(array, 0, newArray, 0, array.length);
    array = newArray;
    HEAP_SIZE++;
    array[HEAP_SIZE - 1] = Integer.MIN_VALUE;
    increaseKey(HEAP_SIZE - 1, key);
  }
}
