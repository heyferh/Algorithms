package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/9/2015.
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] input = {11, 12, 1, -5, 20, -5, 11};
    System.out.println(Arrays.toString(mergeSort(input, 0, input.length - 1)));
  }

  public static int[] mergeSort(int[] array, int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(array, p, q);
      mergeSort(array, q + 1, r);
      merge(array, p, q, r);
    }
    return array;
  }

  static void merge(int[] array, int p, int q, int r) {
    int leftLength = q - p + 1;
    int rightLength = r - q;
    int[] leftArray = new int[leftLength];
    int[] rightArray = new int[rightLength];
    for (int i = 0; i < leftLength; i++) {
      System.arraycopy(array, p, leftArray, 0, leftLength);
    }
    for (int i = 0; i < rightLength; i++) {
      System.arraycopy(array, p + leftLength, rightArray, 0, rightLength);
    }
    int leftCursor = 0;
    int rightCursor = 0;
    for (int k = p; k < r; k++) {
      if (leftArray[leftCursor] <= rightArray[rightCursor]) {
        array[k] = leftArray[leftCursor];
        if (++leftCursor == leftLength) {
          System.arraycopy(rightArray, rightCursor, array, k + 1, rightLength - rightCursor);
          break;
        }

      } else {
        array[k] = rightArray[rightCursor];
        if (++rightCursor == rightLength) {
          System.arraycopy(leftArray, leftCursor, array, k + 1, leftLength - leftCursor);
          break;
        }
      }
    }
  }
}


