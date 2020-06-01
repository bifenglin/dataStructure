import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-19 11:14
 **/
public class SumToTarget {

    public static int getResult(int[] nums, int target){
        if (nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int temp = Integer.MAX_VALUE;
        int res = 0;
        while (left < right){
            int lleft = left + 1;
            int rright = right ;
            int sum = 0;
            while (lleft < rright){
                sum = nums[left] + nums[lleft] + nums[rright];
                if (temp > Math.abs(sum - target)){
                    res = sum;
                    temp = Math.abs(sum - target);
                }
                lleft++;
            }

            if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 1, 4, 10};
        System.out.println(getResult(nums, 16));
    }
}
