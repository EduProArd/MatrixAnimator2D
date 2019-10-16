package me.eduardwayland.matrixanimator;

import me.eduardwayland.matrixanimator.matrix.MatrixFrame;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        init(frame, args);
    }

    /*
    Fields
     */
    private static final JFrame frame = new JFrame();
    private static final MatrixFrame matrixFrame = new MatrixFrame();

    /*
    Init / Disable
     */
    public static void init(JFrame frame, String[] args) {
        frame.setTitle("MatrixAnimator");
        frame.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 500) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2, 500, 500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int rows = 5;
        int cols = 5;
        if (args.length == 2) {
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);
        }
        matrixFrame.setRows(rows);
        matrixFrame.setCols(cols);

        frame.add(matrixFrame);
        frame.setVisible(true);

        if (!useNashorn()) Animations.runAnimation(matrixFrame);

        Animations.startAnimation(matrixFrame);
    }

    public static boolean useNashorn() {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        try {
            engine.eval(new FileReader("animation.js"));
            ((Invocable) engine).invokeFunction("createAnimation", matrixFrame);
            return true;
        } catch (ScriptException | NoSuchMethodException | FileNotFoundException se) {
            return false;
        }
    }

}