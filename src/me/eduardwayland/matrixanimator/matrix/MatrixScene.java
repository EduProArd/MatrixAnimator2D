package me.eduardwayland.matrixanimator.matrix;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.awt.*;
import java.util.LinkedList;

/**
 * This is the object representing an animation scene.
 * It contains the color and the cells that this scene interacts with.
 */
@Getter
@EqualsAndHashCode
public final class MatrixScene {

    /*
    Fields
     */
    private final Color color;
    private final LinkedList<MatrixPoint> cells = new LinkedList<>();

    /*
    Constructor
     */

    /**
     * @param color the color used for the cells of this scene.
     */
    public MatrixScene(Color color) {
        this.color = color;
    }

    /*
    Methods
     */

    /**
     * Adds the cell at the indicated coordinates into the scene.
     *
     * @param y the row.
     * @param x the column.
     */
    public void fillCell(int y, int x) {
        cells.add(new MatrixPoint(x, y, color));
    }

}