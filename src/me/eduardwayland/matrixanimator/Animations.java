package me.eduardwayland.matrixanimator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.eduardwayland.matrixanimator.matrix.MatrixFrame;
import me.eduardwayland.matrixanimator.matrix.MatrixScene;
import me.eduardwayland.matrixanimator.matrix.task.MatrixAnimationTask;

import java.awt.*;
import java.util.Timer;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Animations {

    public static void runAnimation(MatrixFrame matrixFrame) {
        MatrixScene matrixScene1 = new MatrixScene(Color.GREEN);
        MatrixScene matrixScene2 = new MatrixScene(Color.RED);
        for (int y = 0; y < matrixFrame.getRows(); y++) {
            for (int x = 0; x < matrixFrame.getCols(); x++) {
                if (y % 2 == 0) matrixScene1.fillCell(y, x);
                else matrixScene2.fillCell(y, x);
            }
        }
        matrixFrame.addMatrixScene(matrixScene1);
        matrixFrame.addMatrixScene(matrixScene2);
    }

    public static void startAnimation(MatrixFrame matrixFrame) {
        new Timer().schedule(new MatrixAnimationTask(matrixFrame, true), 0, 100);
    }
}