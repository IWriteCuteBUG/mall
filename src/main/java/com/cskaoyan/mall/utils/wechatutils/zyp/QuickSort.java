package com.cskaoyan.mall.utils.wechatutils.zyp;

/*
* 快速排序，由大到小
* */
public class QuickSort {
    private static void sort(double [] arr) {
        if (arr == null || arr.length <= 1) return ;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(double[] arr, int low, int high) {
        if (low >= high) return ;
        // 分区操作
        int index = partition(arr, low, high);
//        System.out.println(Arrays.toString(arr));
        // 对左边进行快速排序
        quickSort(arr, low, index - 1);
        // 对右边进行快速排序
        quickSort(arr, index + 1, high);
    }

    private static int partition(double[] arr, int low, int high) {
        double pivot = arr[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static double[] quickSort(double[] arr) {
        sort(arr);
        return arr;
    }
}
