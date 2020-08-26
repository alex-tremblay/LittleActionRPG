package com.alexandre.rpg.state;

import com.alexandre.rpg.utils.GameWindow;

import javax.swing.*;
import java.awt.*;

/**
 * The game state, in witch the player is playing, the game in this game state ;P
 */
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
