package com.alexandre.rpg.state;

import com.alexandre.rpg.GameWindow;

import javax.swing.*;
import java.awt.*;

public class GameState implements State{
    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        JFrame gameFrame = GameWindow.getInstance().getFrame();
        graphics.drawLine(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
    }
}
