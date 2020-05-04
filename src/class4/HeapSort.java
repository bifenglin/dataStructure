package class4;

/**
 * @program: dataStructure
 * @description:
 * @author: maple
 * @create: 2020-05-04 20:30
 **/
public class HeapSort {
    // 堆排序额外空间复杂度O(1)
    public static void heapSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 +1;
        while (left < heapSize){
            int largest = arr[left + 1] < heapSize && arr[left + 1] > arr[left] ? left + 1: left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
