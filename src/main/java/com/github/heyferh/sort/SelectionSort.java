package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/9/2015.
 */
public class SelectionSort {
  public static void main(String[] args) {
    int[] input = {31, 41, 59, 26, 58, 41};
    System.out.println(Arrays.toString(sort(input)));
  }

  static int[] sort(int[] A) {
    int START_BARRIER = 0;
    int MIN_POSITION = 0;
    while (START_BARRIER < A.length - 1) {
      int MIN = A[START_BARRIER];
      for (int i = START_BARRIER; i < A.length; i++) {
        if (A[i] < MIN) {
          MIN = A[i];
          MIN_POSITION = i;
        }
      }
      int tmp = A[START_BARRIER];
      A[START_BARRIER] = MIN;
      A[MIN_POSITION] = tmp;
      START_BARRIER++;
    }
    return A;
  }
}
