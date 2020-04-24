package class1;

import util.ArrUtil;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 选择排序
 * @author: maple
 * @create: 2020-04-24 17:46
 **/
public class SelectorSort {

    public static void main(String[] args) {
        int testTime = 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = arr.clone();
//            System.out.println(Arrays.toString(arr));
            selectorSort(arr);
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

    public static int[] selectorSort(int[] data){

        for (int i = 0; i < data.length; i++) {
            int index = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[index]){
                    index = j;
                }
            }
            swap(data, i, index);
        }
        return data;
    }

    static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
