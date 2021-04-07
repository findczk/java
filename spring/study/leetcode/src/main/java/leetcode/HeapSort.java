package leetcode;

/**
 * @author dsx
 */
public class HeapSort {
    private int len;

    //建立大顶堆(parent的值不小于left和right的值)
    private void buildMaxHeap(int[] arr) {
        len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            buildMaxHeap(arr, i);
        }
    }

    /*
     堆调整
                0
              /   \
             1     2
           /  \   /   \
          3    4 5     6
     --------------------------------
          parent
          /    \
         left  right
     数字代表数组下标,left = parent*2+1,right = parent*2+2
     */
    private void buildMaxHeap(int[] arr, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < len && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < len && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            buildMaxHeap(arr, largest);
        }


    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void sort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            buildMaxHeap(arr, 0);
        }
    }
}
