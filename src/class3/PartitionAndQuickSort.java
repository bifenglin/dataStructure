package class3;

import class2.ReverseList;
import util.ArrUtil;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-01 17:22
 **/
public class PartitionAndQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int L, int R) {
        int left = L;
        int right = R;
        int index = arr[L];
        while (left < right){
            while (arr[right] >= index && left < right){
                right--;
            }
            while (arr[left] <= index && left < right){
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, L, left);
        return left;
    }

    public static int partition1(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }


    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, L};
        }
        int lessEqual = L - 1;
        int moreEqual = R;
        int index = L;

        while (index < moreEqual){
            if (arr[index] == arr[R]){
                index++;
            } else if (arr[index] < arr[R]){
                swap(arr, index++, ++lessEqual);
            } else {
                swap(arr, index, --moreEqual);
            }
        }
        swap(arr, R, moreEqual);
        return new int[]{lessEqual + 1, moreEqual};
    }


    public static void quckSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int m = partition(arr, L, R);
        quckSort(arr, L, m - 1);
        quckSort(arr, m + 1, R);
    }

    public static void quckSort1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int m = partition1(arr, L, R);
        quckSort1(arr, L, m - 1);
        quckSort1(arr, m + 1, R);
    }

    public static void quckSort2(int[] arr, int L, int R) {
        if (L >= R){
            return;
        }
        int[] area = netherlandsFlag(arr, L, R);
        quckSort2(arr, 0, area[0] - 1);
        quckSort2(arr, area[1] + 1, R);
    }

    public static void main(String[] args) {
        int len = 100;
        int value = 100;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrUtil.generateRandomArray(len, value);
            int[] arr1 = arr.clone();
            int[] arr2 = arr.clone();
            quckSort(arr, 0, arr.length - 1);
            quckSort1(arr1, 0, arr.length - 1);
            quckSort2(arr2, 0, arr.length - 1);
            if (!ArrUtil.isEqual(arr, arr1) || !ArrUtil.isEqual(arr, arr2)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println("oops");
                break;
            }

        }
        System.out.println("finish!");
    }
}
