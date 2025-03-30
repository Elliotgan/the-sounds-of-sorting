package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 * 
 * @param <T>
 */
public class CopyEvent<T> implements SortEvent<T> {

    int index;
    T val;

    /**
     * Indicates a value has been copied into an array
     * 
     * @param index the index value coppied to
     * @param val   the value coppied into array
     */
    public CopyEvent(int index, T val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public void apply(T[] arr) {
        arr[index] = val;
    }

    /**
     * @return a list of the indices affected by this event
     */
    @Override
    public List<Integer> getAffectedIndices() {
        List ret = new ArrayList();
        ret.add(index);
        return ret;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
