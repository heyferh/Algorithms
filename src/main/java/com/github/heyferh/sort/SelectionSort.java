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

  public static int[] sort(int[] array) {
    int START_BARRIER = 0;
    int MIN_POSITION = 0;
    while (START_BARRIER < array.length - 1) {
      int MIN = array[START_BARRIER];
      for (int i = START_BARRIER; i < array.length; i++) {
        if (array[i] < MIN) {
          MIN = array[i];
          MIN_POSITION = i;
        }
      }
      int tmp = array[START_BARRIER];
      array[START_BARRIER] = MIN;
      array[MIN_POSITION] = tmp;
      START_BARRIER++;
    }
    return array;
  }
}
