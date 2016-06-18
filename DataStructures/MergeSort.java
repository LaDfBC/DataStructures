package DataStructures;

import java.util.Random;

/**
 * Created by squeaky on 6/18/16
 */
public class MergeSort {
    public static void main(String[] args) {
        Integer[] test = new Integer[10];
        for(int i = 0; i < 10; i ++) {
            test[i] = new Random().nextInt() % 2;
        }


        MergeSort firstTest = new MergeSort(test);
        printArray(firstTest.mergeSort(0, test.length - 1));
    }

    private static void printArray(Integer[] input) {
        for(int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    MergeSort(Integer[] input) {
        array = input;
    }

    Integer[] array;

    public Integer[] mergeSort(int low, int high) {
        if(low < high) {
            int middle = (low + high) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }

        return array;
    }

    public void merge(int low, int middle, int high) {
        int middleIter = middle + 1;
        int lowIter = low;
        int tempIter = 0;
        Integer[] temp = new Integer[high - low + 1];
        while(lowIter <= middle && middleIter <= high) {
            if(array[lowIter] < array[middleIter]) {
                temp[tempIter++] = array[lowIter++];
            } else {
                temp[tempIter++] = array[middleIter++];
            }
        }

        while(lowIter <= middle) {
            temp[tempIter++] = array[lowIter++];
        }
        while(middleIter <= high) {
            temp[tempIter++] = array[middleIter++];
        }

        tempIter = 0;
        for(int i = low; i <= high; i++) {
            array[i] = temp[tempIter++];
        }
    }
}
