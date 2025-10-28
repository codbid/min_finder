package org.example.excelparser.app.util;

import java.util.List;

public class QuickSelect {
    public static int select(List<Integer> list, int n) {
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return quickSelect(arr, 0, arr.length - 1, n);
    }

    private static int quickSelect(int[] arr, int left, int right, int n) {
        while (true) {
            if (left == right)
                return arr[left];

            int pivot = partition(arr, left, right);

            if (n == pivot)
                return arr[pivot];
            else if (n < pivot)
                right = pivot - 1;
            else
                left = pivot + 1;
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotVal = arr[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < pivotVal) i++;
            while (arr[j] > pivotVal) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
