package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/16/2015.
 */
public class HeapSort {
  private static int HEAP_SIZE;
  private static int[] array;

  public static void main(String[] args) {
    sort(new int[]{3, 2, 4, 0, -4, -5});
    System.out.println(Arrays.toString(array));
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
}
