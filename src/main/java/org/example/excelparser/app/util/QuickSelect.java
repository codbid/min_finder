package org.example.excelparser.app.util;

public class QuickSelect {
    public static int select(int[] arr, int n) {
        return quickSelect(arr, 0, arr.length - 1, n);
    }

    private static int quickSelect(int[] arr, int left, int right, int n) {
        while (true) {
            if (left == right)
                return arr[left];

            int pivot = partition(arr, left, right);

            if (n == pivot)
                return arr[pivot];
            else if (n <= pivot)
                right = pivot;
            else
                left = pivot + 1;
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = arr[mid];
        int i = left;
        int j = right;

        while (true) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i >= j)
                return j;

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
