package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * 
     * @param notes  the note indices
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        Integer[] intarr = notes.getNotes();
        int barWidth = this.getWidth() / intarr.length;
        int height = getHeight();
        int longgest = intarr[0];
        int minimumheight = height / 20;
        for (int iter = 0; iter < intarr.length; iter++) {
            if (intarr[iter] > longgest) {
                longgest = intarr[iter];
            }
        }

        double highcast = ((double) height - minimumheight) / longgest;
        g.clearRect(0, 0, this.getWidth(), height);
        for (int iter = 0; iter < intarr.length; iter++) {
            int currentval = intarr[iter];
            int barHeight = (int) (currentval * highcast + minimumheight);
            double colorpercentage = ((double) barHeight) / height;
            int blueval = (int) (255 * colorpercentage);
            g.setColor(new Color(35, 135, blueval));
            g.fillRect((iter * barWidth), height - barHeight, barWidth, barHeight);
        }
    }
}