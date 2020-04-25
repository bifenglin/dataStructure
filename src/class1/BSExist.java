package class1;

import java.util.Arrays;
import java.util.Random;

import util.ArrUtil;

public class BSExist {
    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSuccess = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
            if(arr.length == 0)
                continue;
            int target = arr[(int)Math.random() * maxSize];
//            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);
            if (!bSExist(arr, target)){
                isSuccess = false;
                System.out.println("fuck!");
                System.out.println(Arrays.toString(arr));
                System.out.println(target);
            }
        }
        if (isSuccess){
            System.out.println("success!");
        }
    }

    public static boolean bSExist(int[] arr, int target){
        if(arr.length == 0) return false;
        int left = 0;
        int right = arr.length -1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] == target){
                return true;
            } else if(arr[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] == target;
    }
}