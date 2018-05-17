package jaba.arrays;

import java.util.Arrays;

public class TraversingArrays {
  static int[][] TDLR(int n) {
    int[][] array = new int[n][n];
    int m = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        m++;
        array[i][j] = m;
      }
    }
    return array;
  }

  static int[][] TDRL(int n) {
    int[][] array = new int[n][n];
    int m = 0;
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j >= 0; j--) {
        m++;
        array[i][j] = m;
      }
    }
    return array;
  }

  static int[][] BULR(int n) {
    int[][] array = new int[n][n];
    int m = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        m++;
        array[i][j] = m;
      }
    }
    return array;
  }

  static int[][] BURL(int n) {
    int[][] array = new int[n][n];
    int m = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        m++;
        array[i][j] = m;
      }
    }
    return array;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(TraversingArrays.TDLR(2)));
    System.out.println(Arrays.deepToString(TraversingArrays.TDLR(5)));
    System.out.println(Arrays.deepToString(TraversingArrays.TDRL(2)));
    System.out.println(Arrays.deepToString(TraversingArrays.TDRL(5)));
    System.out.println(Arrays.deepToString(TraversingArrays.BULR(2)));
    System.out.println(Arrays.deepToString(TraversingArrays.BULR(5)));
    System.out.println(Arrays.deepToString(TraversingArrays.BURL(2)));
    System.out.println(Arrays.deepToString(TraversingArrays.BURL(5)));
  }
}
