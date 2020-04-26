package class1;

import util.ArrUtil;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 最右树
 * @author: maple
 * @create: 2020-04-25 09:23
 **/
public class BSNearRight {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != bSnearRight(arr, value)) {
                Arrays.toString(arr);
                System.out.println(Arrays.toString(arr));
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(bSnearRight(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


    // for test
    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }


    public static int bSnearRight(int[] arr, int target){
        if (arr.length <= 0) return -1;
        int left = 0;
        int right = arr.length -1;
        int index = -1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= target){
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;

    }

}
