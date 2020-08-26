package com.alexandre.rpg;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private static GameWindow _gameWindowInstance;
    private GameWindow() { }
    public static GameWindow getInstance() {
        if (_gameWindowInstance == null)
            _gameWindowInstance = new GameWindow();
        return _gameWindowInstance;
    }

    private JFrame _frame;
    public void createWindow(Panel panel) {
        _frame = new JFrame();
        _frame.setTitle("LittleActionRPG");
        _frame.setSize(new Dimension(600, 400));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.add(panel);
        _frame.setVisible(true);
    }

    public JFrame getFrame() {
        return _frame;
    }
}
