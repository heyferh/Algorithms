package com.github.heyferh.search;

import com.github.heyferh.sort.InsertionSort;

import java.util.Arrays;

/**
 * Created by feku on 9/11/2015.
 */
public class BinarySearch {
  public static void main(String[] args) {
    int[] inputArray = {2, 4, 3, 5, 6, 9, 7, 45, 3, 5, 8, 0};
    InsertionSort.recursiveSort(inputArray, inputArray.length);
    System.out.println(search(inputArray, 45));
  }

  public static boolean search(int[] array, int n) {
    if (array.length == 0) {
      return false;
    }
    int q = array.length / 2;
    if (array[q] == n) {
      return true;
    } else if (array[q] < n) {
      return search(Arrays.copyOfRange(array, q + 1, array.length), n);
    } else {
      return search(Arrays.copyOfRange(array, 0, q), n);
    }
  }
}
