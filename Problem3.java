/**************************************************************
 Purpose/Description: <>
 Author’s Panther ID: <5901749>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/
/*

*/
package problem.pkg1;

/**
 *
 * @author Joey
 */


class QuickSort {
    
    // creates a sorting for an array
    public static void qSort(int[] intArray) {
        quicksort(intArray, 0, intArray.length - 1);
    }

    private static final int CUTOFF = 3;

    // indexes the array 
    public static final void swapReferences(int[] intArray, int firstIndex, int secondIndex) {
        int tempVar = intArray[firstIndex];
        intArray[firstIndex] = intArray[secondIndex];
        intArray[secondIndex] = tempVar;
    }
    
    // divide and conq the array 
    private static int median3(int[] intArray, int left, int right) {
        int center = (left + right) / 2;
        if (intArray[center] < intArray[left]) {
            swapReferences(intArray, left, center);
        }
        if (intArray[right] < intArray[left]) {
            swapReferences(intArray, left, right);
        }
        if (intArray[right] < intArray[center]) {
            swapReferences(intArray, center, right);
        }
        swapReferences(intArray, center, right - 1);
        return intArray[right - 1];
    }

    // keeps checking the pivot of the array 
    private static void quicksort(int[] intArray, int left, int right) {
        
        if (left + CUTOFF <= right) {
            int pivot = median3(intArray, left, right);

            int i = left, j = right - 1;
            for (;;) {
                while (intArray[++i] < pivot) {
                }
                while (intArray[--j] > pivot) {
                }
                if (i < j) {
                    swapReferences(intArray, i, j);
                } else {
                    break;
                }
            }

            swapReferences(intArray, i, right - 1);

            quicksort(intArray, left, i - 1); 
            quicksort(intArray, i + 1, right);
        }
    }

}

public class Problem3 {

    // sorts the given array 
    public static void main(String[] args) {
        int[] intArray = {24, 2, 4, 466, 48, 66, 8, 44};
        QuickSort.qSort(intArray);
        
        // outputs the array 
        System.out.print("Output:");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

}

/*
(b) The processing time of an algorithm is described by the following recurrence equation (c is a positive constant):

        T(n) = 3T(n/3) + 2cn

        T(1) = 0
Answer: 
         The “BigOh” complexity of this algorithm is O(n log n).

*/


