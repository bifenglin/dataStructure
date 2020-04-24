package class1;

import util.ArrUtil;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 冒泡排序
 * @author: maple
 * @create: 2020-04-24 18:03
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int testTime = 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = arr.clone();
//            System.out.println(Arrays.toString(arr));
            BubbleSort(arr);
            SelectorSort.selectorSort(arr2);
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

    static int[] BubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]){
                    ArrUtil.swap(arr, j-1, j);
                }
            }
        }
        return arr;
    }

}
