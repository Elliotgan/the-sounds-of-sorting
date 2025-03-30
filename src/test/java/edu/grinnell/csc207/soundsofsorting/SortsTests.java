package edu.grinnell.csc207.soundsofsorting;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.bubbleSort;
import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.eventSort;
import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.insertionSort;
import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.mergeSort;
import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.mySort;
import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.quickSort;
import static edu.grinnell.csc207.soundsofsorting.sorts.Sorts.selectionSort;
import java.util.Arrays;
import java.util.List;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    
    public static Integer[] makeTestArray2() {
        return new Integer[] {
        };
    }

    public static Integer[] makeTestArray3() {
        return new Integer[] {
            19, 18, 17, 16, 15, 14,
            13, 12, 11, 10, 9, 8,
            7, 6, 5, 4, 3, 2, 1, 0
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    


    @Test
    public void testBubbleSort() {
        Integer[] arr = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> events = bubbleSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray2();
        arr2 = makeTestArray2();
        events = bubbleSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray3();
        arr2 = makeTestArray3();
        events = bubbleSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));
        
    }
    
    @Test
    public void testInsertionSort() {
        Integer[] arr = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> events = insertionSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray2();
        arr2 = makeTestArray2();
        events = insertionSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray3();
        arr2 = makeTestArray3();
        events = insertionSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));
    }
    
    @Test
    public void testSelectionSort() {
        Integer[] arr = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> events = selectionSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray2();
        arr2 = makeTestArray2();
        events = selectionSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray3();
        arr2 = makeTestArray3();
        events = selectionSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> events = mergeSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray2();
        arr2 = makeTestArray2();
        events = mergeSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray3();
        arr2 = makeTestArray3();
        events = mergeSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));
    }
    
    @Test
    public void testQuickSort() {
        Integer[] arr = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> events = quickSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray2();
        arr2 = makeTestArray2();
        events = quickSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray3();
        arr2 = makeTestArray3();
        events = quickSort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));
    }
    
    @Test
    public void testMySort() {
        Integer[] arr = makeTestArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        List<SortEvent<Integer>> events = mySort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray2();
        arr2 = makeTestArray2();
        events = mySort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));

        arr = makeTestArray3();
        arr2 = makeTestArray3();
        events = mySort(arr);
        eventSort(arr2, events);
        assertTrue(sorted(arr));
        assertTrue(sorted(arr2));
    }
}