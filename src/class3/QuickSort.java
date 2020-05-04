package class3;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{3,45,78,64,52,11,64,55,99,11,18};
        sort(input, 0, input.length-1);
        for (int i : input){
            System.out.print(i+" ");
        }
    }

    public static void sort(int[] arr, int low, int high){
        // left 左指针 right 右指针 base 基准
        int left, right, base, temp;
        // 递归跳出条件
        if (low > high) {
            return;
        }
        left = low;
        right = high;
        //temp就是基准位
        base = arr[low];

        while (left < right) {
            //先看右边，依次往左递减
            while (base <= arr[right] && left < right) {
                right--;
            }
            //再看左边，依次往右递增
            while (base >= arr[left] && left < right) {
                left++;
            }
            //如果满足条件则交换
            if (left < right) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[left];
        arr[left] = base;
        //递归调用左半数组
        sort(arr, low, right - 1);
        //递归调用右半数组
        sort(arr, right + 1, high);
    }
}
