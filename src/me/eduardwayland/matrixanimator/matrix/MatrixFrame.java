package me.eduardwayland.matrixanimator.matrix;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * This is the object representing the panel where the matrix animation plays in.
 */
@Getter
public class MatrixFrame extends JPanel {

    /*
    Fields
     */
    private int rows;
    private int cols;
    private int[][] matrix;

    private final LinkedList<MatrixScene> scenes = new LinkedList<>();
    private final LinkedList<MatrixPoint> points = new LinkedList<>();

    /*
    Methods
     */

    /**
     * Repaints the matrix with the possible new matrix attributes.
     */
    private void redefineMatrix() {
        matrix = new int[rows][cols];
        repaint();
    }

    /**
     * Sets the new matrix rows amount and repaints the matrix if the amount is different than the current one.
     *
     * @param rows the amount of rows.
     */
    public void setRows(int rows) {
        if (this.rows == rows) return;
        this.rows = rows;
        redefineMatrix();
    }

    /**
     * Sets the new matrix columns amount and repaints the matrix if the amount is different than the current one.
     *
     * @param cols the amount of rows.
     */
    public void setCols(int cols) {
        if (this.cols == cols) return;
        this.cols = cols;
        redefineMatrix();
    }

    /**
     * @param matrixScene the new MatrixScene instance.
     */
    public void addMatrixScene(MatrixScene matrixScene) {
        if (scenes.contains(matrixScene)) return;
        scenes.add(matrixScene);
    }

    /**
     * Adds the cell that is going to be painted.
     *
     * @param matrixPoint the cell instance.
     */
    public void addPoint(MatrixPoint matrixPoint) {
        points.add(matrixPoint);
        repaint();
    }

    /*
    Overriden Methods
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Width and Height must be 10% of the entire window
        int cellWidth = 10 * g.getClipBounds().width / 100;
        int cellHeight = 10 * g.getClipBounds().height / 100;
        System.out.printf("Width: %d \t Height: %d \n", cellWidth, cellHeight);

        int frameCenterX = g.getClipBounds().width / 2;
        int frameCenterY = g.getClipBounds().height / 2;
        System.out.printf("Frame Center X: %d \t Frame Center Y: %d \n", frameCenterX, frameCenterY);

        // Matrix dimensions
        int matrixWidth = cols * cellWidth;
        int matrixHeight = rows * cellHeight;
        int matrixCenterX = matrixWidth / 2;
        int matrixCenterY = matrixHeight / 2;

        Graphics2D g2 = (Graphics2D) g;

        // Draw cells
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLACK);
        for (int currentY = frameCenterY - matrixCenterY; currentY < matrixCenterY + frameCenterY; currentY += cellHeight) {
            for (int currentX = frameCenterX - matrixCenterX; currentX < matrixCenterX + frameCenterX; currentX += cellWidth) {
                g.drawRect(currentX, currentY, cellWidth, cellHeight);
            }
        }

        // Fill cells
        g2.setStroke(new BasicStroke(1));
        for (MatrixPoint matrixPoint : points) {
            g2.setColor(matrixPoint.getColor());
            int x = frameCenterX - matrixCenterX + cellWidth * matrixPoint.getX() + 1;
            int y = frameCenterY - matrixCenterY + cellHeight * matrixPoint.getY() + 1;

            g2.fillRect(x + 1, y + 1, cellWidth - 1 - 2, cellHeight - 1 - 2);
        }
    }
}