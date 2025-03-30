package edu.grinnell.csc207.soundsofsorting;

import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {

    private Integer[] indices;
    private ArrayList<Integer> highlights;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        this.indices = new Integer[n];
        highlights = new ArrayList<Integer>();
        for (int iter = 0; iter < n; iter++) {
            indices[iter] = iter;
        }
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an initial
     * starting point for the sorting process.
     *
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        this.indices = new Integer[n];
        highlights = new ArrayList<Integer>();
        for (int iter = 0; iter < n; iter++) {
            indices[iter] = iter;
        }
        Random rand = new Random();
        for (int iter = indices.length - 1; iter >= 0; iter--) {
            int swapIndex = rand.nextInt() % (iter + 1);
            swapIndex = Math.abs(swapIndex);
            int temp = indices[swapIndex];
            indices[swapIndex] = indices[iter];
            indices[iter] = temp;
        }
    }

    /**
     * @return the indices of this NoteIndices object
     */
    public Integer[] getNotes() {
        return indices;
    }

    /**
     * Highlights the given index of the note array
     *
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        // System.out.println("wow, highlight" + index);
        // System.out.println("current note length is " + this.indices.size());
        highlights.add(index);
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        for (int iter = 0; iter < highlights.size(); iter++) {
            if (highlights.get(iter) == index) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears all highlighted indices from this collection
     */
    public void clearAllHighlighted() {
        highlights.clear();
    }
}
