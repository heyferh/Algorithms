package com.github.heyferh.search;

import java.util.Arrays;

/**
 * Created by feku on 9/14/2015.
 */
public class FindMaxCrossingSubarray {
  public static void main(String[] args) {
    int[] testArray = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    System.out.println(Arrays.toString(findMaximumSubarray(testArray, 0, testArray.length - 1)));

  }

  public static int[] findMaximumSubarray(int[] array, int low, int high) {
    if (high == low) {
      return new int[]{low, high, array[low]};
    } else {
      int mid = (low + high) / 2;
      int[] left = findMaximumSubarray(array, low, mid);
      int[] right = findMaximumSubarray(array, mid + 1, high);
      int[] cross = findMaxCrossingSubarray(array, low, mid, high);
      if (left[2] >= right[2] && left[2] >= cross[2]) {
        return new int[]{left[0], left[1], left[2]};
      } else if (right[2] >= left[2] && right[2] >= cross[2]) {
        return new int[]{right[0], right[1], right[2]};
      } else {
        return new int[]{cross[0], cross[1], cross[2]};
      }
    }
  }

  public static int[] findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
    int RIGHT_SUM = Integer.MIN_VALUE;
    int LEFT_SUM = Integer.MIN_VALUE;
    int max_left = 0;
    int max_right = 0;
    int sum = 0;
    for (int i = mid; i >= low; i--) {
      sum += array[i];
      if (sum > LEFT_SUM) {
        LEFT_SUM = sum;
        max_left = i;
      }
    }
    sum = 0;
    for (int i = mid + 1; i <= high; i++) {
      sum += array[i];
      if (sum > RIGHT_SUM) {
        RIGHT_SUM = sum;
        max_right = i;
      }
    }
    return new int[]{max_left, max_right, LEFT_SUM + RIGHT_SUM};
  }
}
