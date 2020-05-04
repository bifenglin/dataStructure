package class3;

import util.ArrUtil;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-01 15:57
 **/
public class MergeSort {

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void mergeSort1(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        progress(data, 0, data.length - 1);
    }

    // 非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void progress(int[] data, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 2);
        progress(data, left, mid);
        progress(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int res[] = new int[right - left + 1];
        int index = 0;
        int l = left;
        int m = mid + 1;
        while (l <= mid && m <= right) {
            if (arr[m] > arr[l]) {
                res[index++] = arr[l++];
            } else {
                res[index++] = arr[m++];
            }
        }
        while (l <= mid) {
            res[index++] = arr[l++];
        }
        while (m <= right) {
            res[index++] = arr[m++];
        }
        System.arraycopy(res, 0, arr, left, right - left + 1);
    }

//    public static void merge(int[] arr, int L, int M, int R) {
//        int[] help = new int[R - L + 1];
//        int i = 0;
//        int p1 = L;
//        int p2 = M + 1;
//        while (p1 <= M && p2 <= R) {
//            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//        }
//        while (p1 <= M) {
//            help[i++] = arr[p1++];
//        }
//        while (p2 <= R) {
//            help[i++] = arr[p2++];
//        }
//        for (i = 0; i < help.length; i++) {
//            arr[L + i] = help[i];
//        }
//    }

}
