package com;

public class MergeSort {
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int len1 = mid - start + 1;
        int len2 = end - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        for (int i = 0; i < len1; i++) {
            leftArr[i] = nums[start + i];
        }
        for (int i = 0; i < len2; i++) {
            rightArr[i] = nums[mid + i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (leftArr[i] <=  rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            nums[k++] = leftArr[i++];
        }
        while (j < len2) {
            nums[k++] = rightArr[j++];
        }
    }
}
