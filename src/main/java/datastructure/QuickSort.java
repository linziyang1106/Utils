package datastructure;

import java.util.Arrays;

/**
 * @author linzy
 * @create 2021-03-08 11:20:42
 */
public class QuickSort {

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // TODO: 将 arr 从 left 到 right 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {3, 2, 1, 5, 7, 6, 23, 1, 21, 12, 32};
        int[] sort = new QuickSort().sort(nums);
        System.out.println(Arrays.toString(sort));
    }

}
