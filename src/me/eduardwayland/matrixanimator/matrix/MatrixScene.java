package me.eduardwayland.matrixanimator.matrix;

import lombok.Getter;

import java.awt.*;
import java.util.LinkedList;

@Getter
public final class MatrixScene {

    /*
    Fields
     */
    private final Color color;
    private final LinkedList<MatrixPoint> cells = new LinkedList<>();

    /*
    Constructor
     */
    public MatrixScene(Color color) {
        this.color = color;
    }

    /*
    Methods
     */
    public void fillCell(int y, int x) {
        cells.add(new MatrixPoint(x, y, color));
    }

}