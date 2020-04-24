package class1;

import java.util.Arrays;

import util.ArrUtil;

public class InsertSort {
    public static void main(String[] args) {
        int testTime = 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = arr.clone();
//            System.out.println(Arrays.toString(arr));
            insertSort(arr);
            Arrays.sort(arr2);
            if (!ArrUtil.isEqual(arr, arr2)){
                isSuccess = false;
                System.out.println("fuck!");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
            }
        }
        if (isSuccess){
            System.out.println("success!");
        }
    }

    public static int[] insertSort(int[] arr){
        if(arr.length <=1) return arr;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){
                for (int j = i - 1; j >=0 && arr[j] > arr[j+1] ; j--) {
                    ArrUtil.swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    // public static void insertionSort(int[] arr) {
	// 	if (arr == null || arr.length < 2) {
	// 		return;
	// 	}
	// 	// 0~0 有序的
	// 	// 0~i 想有序
	// 	for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
			
	// 		// arr[i]往前看，一直交换到合适的位置停止
	// 		// ...(<=)  ?       <- i
	// 		for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
	// 			swap(arr, j, j + 1);
	// 		}
	// 	}
	// }
}