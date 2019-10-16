package me.eduardwayland.matrixanimator.matrix;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

/**
 * An object representing the coordinates and the color of a matrix cell
 */
@Getter
@AllArgsConstructor
public final class MatrixPoint {

    /*
    Fields
     */
    private final int x;
    private final int y;
    private final Color color;
}