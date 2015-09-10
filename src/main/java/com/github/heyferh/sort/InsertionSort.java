package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/9/2015.
 */
public class InsertionSort {
  public static void main(String[] args) {
    int[] input = {31, 41, 59, 26, 41, 58};
    System.out.println(Arrays.toString(sort(input)));
  }

  static int[] sort(int[] A) {
    int key, i;
    for (int j = 1; j < A.length; j++) {
      i = j - 1;
      key = A[j];
      while (i >= 0 && A[i] > key) {
        A[i + 1] = A[i];
        i--;
      }
      A[i + 1] = key;
    }
    return A;
  }
}
