package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 11/2/2015.
 */
public class CountingSort {
  public static void main(String[] args) {
    int[] testArray = {0, 1, 4, 3, 4, 5, 6, 1, 3};
    System.out.println(Arrays.toString(testArray));
    System.out.println(Arrays.toString(countingSort(testArray)));
  }

  private static int[] countingSort(int[] input) {
    int k = Arrays.stream(input).max().getAsInt() + 1;
    int[] temp = new int[k];
    for (int i = 0; i < k; i++) {
      temp[i] = 0;
    }
    for (int i = 0; i < input.length; i++) {
      temp[input[i]] = temp[input[i]] + 1;
    }
    for (int i = 1; i < k; i++) {
      temp[i] = temp[i] + temp[i - 1];
    }
    int[] out = new int[input.length];
    for (int i = input.length - 1; i >= 0; i--) {
      out[temp[input[i]] - 1] = input[i];
      temp[input[i]] = temp[input[i]] - 1;
    }
    return out;
  }
}


