package com.github.heyferh.sort;

import java.util.Arrays;

/**
 * Created by feku on 9/9/2015.
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] input = {11, 22, 33, 44, 1, 12, 13};
    System.out.println(Arrays.toString(merge(input, 0, 3, 6)));
  }

  static int[] merge(int[] A, int p, int q, int r) {
    int leftLength = q - p + 1;
    int rightLength = r - q;
    int[] leftArray = new int[leftLength];
    int[] rightArray = new int[rightLength];
    for (int i = 0; i < leftLength; i++) {
      System.arraycopy(A, 0, leftArray, 0, leftLength);
    }
    for (int i = 0; i < rightLength; i++) {
      System.arraycopy(A, leftLength, rightArray, 0, rightLength);
    }
    int leftCursor = 0;
    int rightCursor = 0;
    for (int k = p; k < r; k++) {
      if (leftArray[leftCursor] <= rightArray[rightCursor]) {
        A[k] = leftArray[leftCursor];
        if (++leftCursor == leftLength) {
          System.arraycopy(rightArray, rightCursor, A, k + 1, rightLength - rightCursor);
          break;
        }

      } else {
        A[k] = rightArray[rightCursor];
        if (++rightCursor == rightLength) {
          System.arraycopy(leftArray, leftCursor, A, k + 1, leftLength - leftCursor);
          break;
        }
      }
    }
    return A;
  }
}


