package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 * 
 * @param <T>
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int index1;
    private int index2;

    /**
     * Indicates a swap happened between two elements
     * 
     * @param index1 the position of first swapped element
     * @param index2 the position of second swapped element
     */
    public SwapEvent(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    /**
     * Applies this event to the array.
     * 
     * @param arr the array to modify
     */
    @Override
    public void apply(T[] arr) {
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * @return a list of the indices affected by this event
     */
    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> ret = new ArrayList<>();
        ret.add(index1);
        ret.add(index2);
        return ret;
    }

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    @Override
    public boolean isEmphasized() {
        return true;
    }
}
