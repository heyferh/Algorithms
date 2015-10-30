package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/22/2015.
 */
public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {2, 1, 4, 3, 2};
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] array, int p, int r) {
    if (p < r) {
      int q = partition(array, p, r);
      sort(array, p, q - 1);
      sort(array, q + 1, r);
    }
  }

  private static int partition(int[] array, int p, int r) {
    int x = array[r];
    int i = p - 1;
    for (int j = p; j < r; j++) {
      if (array[j] <= x) {
        i = i + 1;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, r);
    return i + 1;
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
