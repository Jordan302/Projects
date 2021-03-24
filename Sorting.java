import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Jordan Collins
 * @version 1.0
 */

public class Sorting {

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Sorry. Your arguments can't be null.");
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && comparator.compare(arr[j - 1], arr[j]) > 0) {
                T swap = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = swap;
                j--;
            }
        }
    }


    /**
     * Implement cocktail sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Sorry. Your arguments can't be null.");
        }
        int startInd = 0;
        int endInd = arr.length - 1;
        int lastSwap = 0;
        while (endInd - startInd > 0) {
            for (int i = startInd; i < endInd; i++) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T swap = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = swap;
                    lastSwap = i;
                }
            }
            endInd = lastSwap;
            for (int i = endInd; i > startInd; i--) {
                if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                    T swap = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = swap;
                    lastSwap = i;
                }
            }
            startInd = lastSwap;
        }
    }



    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Sorry. Your arguments can't be null.");
        }
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int midIndex = length / 2;
        T[] leftArray = (T[]) new Object[midIndex];
        T[] rightArray = (T[]) new Object[length - midIndex];
        for (int i = 0; i <= length - 1; i++) {
            if (i < midIndex) {
                leftArray[i] = arr[i];
            } else {
                rightArray[i - midIndex] = arr[i];
            }
        }
        mergeSort(leftArray, comparator);
        mergeSort(rightArray, comparator);
        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;
        while (leftIndex < midIndex && rightIndex < length - midIndex) {
            if (comparator.compare(leftArray[leftIndex], rightArray[rightIndex]) <= 0) {
                arr[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                arr[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex < midIndex) {
            arr[currentIndex] = leftArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }
        while (rightIndex < length - midIndex) {
            arr[currentIndex] = rightArray[rightIndex];
            rightIndex++;
            currentIndex++;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(kn)
     *
     * And a best case running time of:
     * O(kn)
     *
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Sorry. Your arguments can't be null.");
        }
        LinkedList<Integer>[] buckets = new LinkedList<Integer>[19];
        int greatest = 0;
        for (int num: arr) {
            if (num == Integer.MIN_VALUE) {
                greatest = Integer.MAX_VALUE;
            } else if (Math.abs(num) > greatest) {
                greatest = Math.abs(num);
            }
        }
        int k = 0;
        while (greatest != 0) {
            greatest /= 10;
            k++;
        }
        int divisor = 1;
        for (int iterations = 0; iterations < k; iterations++) {
            if (iterations != 0) {
                divisor *= 10;
            }
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / (divisor) % 10 + 9;
                if (buckets[digit] == null) {
                    buckets[digit] = new LinkedList<Integer>();
                }
                buckets[digit].addLast(arr[i]);
            }
            int index = 0;
            for (LinkedList<Integer> bucket: buckets) {
                if (bucket != null) {
                    while (!bucket.isEmpty()) {
                        arr[index++] = bucket.removeFirst();
                    }
                }
            }
        }
    }



    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots. For example if you
     * need a pivot between a (inclusive) and b (exclusive) where b > a, use
     * the following code:
     *
     * int pivotIndex = rand.nextInt(b - a) + a;
     *
     * If your recursion uses an inclusive b instead of an exclusive one,
     * the formula changes by adding 1 to the nextInt() call:
     *
     * int pivotIndex = rand.nextInt(b - a + 1) + a;
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not receive
     * credit if you do not use the one we have taught you!
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @throws java.lang.IllegalArgumentException if the array or comparator or
     *                                            rand is null
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator, Random rand) {
        if (arr == null || comparator == null || rand == null) {
            throw new IllegalArgumentException("Sorry. Your arguments can't be null.");
        } else {
            quickSort(arr, comparator, rand, 0, arr.length - 1);
        }
    }

    /**
     * A helper method to implement quicksort.
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @param left       the left of the array to be sorted
     * @param right      the right of the array to be sorted
     *
     */
    private static <T> void quickSort(T[] arr, Comparator<T> comparator, Random rand, int left, int right) {
        if (right - left < 1) {
            return;
        }
        int pivotIndex = rand.nextInt(right - left + 1) + left;
        T pivot = arr[pivotIndex];
        T swapLeft = arr[left];
        arr[left] = arr[pivotIndex];
        arr[pivotIndex] = swapLeft;
        int leftIndex = left + 1;
        int rightIndex = right;
        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && comparator.compare(arr[leftIndex], pivot) <= 0) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && comparator.compare(arr[rightIndex], pivot) >= 0) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                T swapIndex = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = swapIndex;
                leftIndex++;
                rightIndex--;
            }
        }
        T swap = arr[left];
        arr[left] = arr[rightIndex];
        arr[rightIndex] = swap;
        quickSort(arr, comparator, rand, left, rightIndex - 1);
        quickSort(arr, comparator, rand, rightIndex + 1, right);
    }
}
