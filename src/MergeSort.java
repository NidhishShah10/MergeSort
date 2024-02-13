import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        mergeSort(left);
        mergeSort(right);
        
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[999];
        Random rand = new Random();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(999);
        }
        
        int[] arrMergeSort = arr.clone();
        int[] arrBubbleSort = arr.clone();
        
        long startTime = System.nanoTime();
        mergeSort(arrMergeSort);
        long mergeSortTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        bubbleSort(arrBubbleSort);
        long bubbleSortTime = System.nanoTime() - startTime;
        
        System.out.println("Merge Sort Time: " + mergeSortTime + " nanoseconds");
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " nanoseconds");
    }
}
