package com.alexandre.rpg.state;

import java.awt.*;

/**
 * All the game state will implement from this
 */
public interface State {
    void init();
    void update();
    void render(Graphics graphics);
}
