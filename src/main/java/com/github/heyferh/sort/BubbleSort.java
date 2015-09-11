package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/11/2015.
 */
public class BubbleSort {
  public static void main(String[] args) {
    int[] inputArray = {1, 3, 2, -5, 10, 2};
    System.out.println(Arrays.toString(sort(inputArray)));
  }

  public static int[] sort(int[] array) {
    for (int BARRIER = array.length - 1; BARRIER > 1; BARRIER--) {
      for (int i = 0; i < BARRIER; i++) {
        if (array[i] > array[i + 1]) {
          int tmp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = tmp;
        }
      }
    }
    return array;
  }
}
