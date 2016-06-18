package DataStructures;

import java.util.Random;

/**
 * Created by squeaky on 6/18/16
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] test = new Integer[10];
        for(int i = 0; i < 10; i ++) {
            test[i] = new Random().nextInt();
        }

        QuickSort sorter = new QuickSort();
        printArray(sorter.quicksort(test));
    }

    private static void printArray(Integer[] input) {
        for(int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    Integer[] array;

    public Integer[] quicksort(Integer [] input) {
        if(input.length <= 1) {
            return input;
        }
        array = input;
        helper(0, input.length - 1);
        return array;
    }

    public void helper(int low, int high) {
        if(low < high) {
            int pivot = partition(low, high);
            helper(low, pivot);
            helper(pivot + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot_position = low;
        int highIter = high - 1;

        while(pivot_position <= highIter) {
            if(array[pivot_position] > array[high]) {
                swap(highIter, pivot_position);
                highIter--;
            }
            else {
                pivot_position++;
            };
        }
        swap(pivot_position, high);
        return highIter;
    }

    private void swap(int highIter, int pivot_position) {
        Integer temp = array[highIter];
        array[highIter] = array[pivot_position];
        array[pivot_position] = temp;
    }
}
