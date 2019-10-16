package me.eduardwayland.matrixanimator.matrix.task;

import lombok.Getter;
import me.eduardwayland.matrixanimator.matrix.MatrixFrame;
import me.eduardwayland.matrixanimator.matrix.MatrixScene;

import java.util.TimerTask;

@Getter
public final class MatrixAnimationTask extends TimerTask {

    /*
    Fields
     */
    private final MatrixFrame matrixFrame;
    private final boolean loop;

    private int matrixSceneIndex = 0;
    private int matrixSceneCellIndex = 0;

    /*
    Constructor
     */
    public MatrixAnimationTask(MatrixFrame matrixFrame, boolean loop) {
        this.matrixFrame = matrixFrame;
        this.loop = loop;
    }

    @Override
    public void run() {
        if (matrixSceneIndex == matrixFrame.getScenes().size()) {
            if (loop) {
                matrixSceneIndex = 0;
                matrixSceneCellIndex = 0;
                matrixFrame.getPoints().clear();
            } else cancel();
            return;
        }

        MatrixScene matrixScene = matrixFrame.getScenes().get(matrixSceneIndex);
        if (matrixSceneCellIndex == matrixScene.getCells().size()) {
            matrixSceneIndex++;
            matrixSceneCellIndex = 0;
            return;
        }
        System.out.printf("Scene: %d/%d \t Cell: %d/%d \n", matrixSceneIndex + 1, matrixFrame.getScenes().size(), matrixSceneCellIndex + 1, matrixScene.getCells().size());

        matrixFrame.addPoint(matrixScene.getCells().get(matrixSceneCellIndex));
        matrixSceneCellIndex++;
    }
}
