package com.alexandre.rpg.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Show the game window to the screen, use with caution, we only want one!
 */
public class GameWindow {

    /**
     * Singleton because we want to access it from a lot of place
     */
    private static GameWindow _gameWindowInstance;
    private GameWindow() { }
    public static GameWindow getInstance() {
        if (_gameWindowInstance == null)
            _gameWindowInstance = new GameWindow();
        return _gameWindowInstance;
    }

    private JFrame _frame;

    /**
     * Create the window and add the game panel in it
     * @param panel
     */
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
