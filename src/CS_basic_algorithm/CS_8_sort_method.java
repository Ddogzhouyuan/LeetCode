package CS_basic_algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class CS_8_sort_method {
    /**
     * 插入排序
     *
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     * @param arr  待排序数组
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j] > temp) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     *
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int j = 0; j + gap < arr.length; j++) {
                for (int k = 0; k + gap < arr.length; k += gap) {
                    if (arr[k] > arr[k + gap]) {
                        int temp = arr[k + gap];
                        arr[k + gap] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * 1. 从待排序序列中，找到关键字最小的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 堆排序
     *
     * 1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
     * 2. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
     * 3. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
     * @param arr  待排序数组
     */
    public static void max_heapify(int[] arr, int limit) {
        if (arr.length <= 0 || arr.length < limit) return;
        int parentIdx = limit / 2;

        for (; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 >= limit) {
                continue;
            }
            int left = parentIdx * 2;
            int right = left + 1 >= limit ? left : left + 1;
            int maxChildId = arr[left] >= arr[right] ? left : right;

            if (arr[maxChildId] > arr[parentIdx]) {
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            max_heapify(arr, i);

            int temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    /**
     * 冒泡排序
     *
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * @param arr  待排序数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length; i >0; i--) {
            for (int j = 0; j < i && j + 1 < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快排
     */
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort2(nums, 0, n - 1);
        return nums;
    }

    private void quickSort2(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivotIndex = partition2(nums, lo, hi);
        quickSort2(nums, lo, pivotIndex - 1);
        quickSort2(nums, pivotIndex + 1, hi);
    }

    private int partition2(int[] nums, int lo, int hi) {
        int randomIndex = RANDOM.nextInt(hi - lo + 1) + lo;
        swap(nums, lo, randomIndex);
        int l = lo;
        int r = hi;
        int pivot = nums[lo];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, lo, l);
        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 快速排序（递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param arr   待排序数组
     * @param low   左边界
     * @param high  右边界
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length <= 0) return;
        if (low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++ ;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    /**
     * 快速排序（非递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 把分区之后两个区间的边界（low和high）压入栈保存，并循环①、②步骤
     * @param arr   待排序数组
     */
    public static int partition(int[] arr, int low, int high) {
        if (arr.length <= 0) return -1;
        if (low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] <= pivot) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] >= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }

    public static void quickSortByStack(int[] arr) {
        if (arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);

            if (pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if (pivotIdx < high && pivotIdx >= 0) {
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
    }

    /**
     * 归并排序（递归）
     *
     * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     * ③. 重复步骤②，直到所有元素排序完毕。
     * @param :arr	 待排序数组
     */
    public static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int num = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        int[] result = mergeTwoArray(mergeSort(leftArr), mergeSort(rightArr));
        return result;
    }

    /**
     * 基数排序（LSD 从低位开始）
     *
     * 基数排序适用于：
     *  (1)数据范围较小，建议在小于1000
     *  (2)每个数值都要大于等于0
     *
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     * @param arr	 待排序数组
     */
    public static void radixSort(int[] arr) {
        if (arr.length <= 1) return;

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max /= 10;
        }

        int[][] buckets = new int[10][arr.length];
        int base = 10;

        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];

            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen.length; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }

    }
}
