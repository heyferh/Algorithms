package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/9/2015.
 */
public class InsertionSort {
  public static void main(String[] args) {
    int[] input = {2, 1};
    System.out.println(Arrays.toString(recursiveSort(input, input.length)));
  }

  public static int[] sort(int[] array) {
    int key, i;
    for (int j = 1; j < array.length; j++) {
      i = j - 1;
      key = array[j];
      while (i >= 0 && array[i] > key) {
        array[i + 1] = array[i];
        i--;
      }
      array[i + 1] = key;
    }
    return array;
  }

  public static int[] recursiveSort(int[] A, int n) {
    if (n == 1) {
      return A;
    }
    recursiveSort(A, n - 1);
    int key = A[n - 1];
    int i;
    for (i = n - 2; i >= 0; i--) {
      if (A[i] > key) {
        A[i + 1] = A[i];
      } else {
        break;
      }
    }
    A[i + 1] = key;
    return A;
  }
}
