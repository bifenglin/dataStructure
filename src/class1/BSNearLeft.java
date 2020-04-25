package class1;

import java.util.Arrays;

import util.ArrUtil;

public class BSNearLeft {
    public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = ArrUtil.generateRandomArray(maxSize, maxValue);
			Arrays.sort(arr);
			int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			if (test(arr, value) != bSNearLeft(arr, value)) {
				Arrays.toString(arr);
				System.out.println(value);
				System.out.println(test(arr, value));
				System.out.println(bSNearLeft(arr, value));
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    	// for test
	public static int test(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= value) {
				return i;
			}
		}
		return -1;
	}

    public static int bSNearLeft(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int index = -1; // 记录最左的对号
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] >= target){
                right = mid - 1;
                index = mid;
            } else{
                left = mid + 1;
            }
        }
        return index;
    }

}