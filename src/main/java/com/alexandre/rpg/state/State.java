package com.alexandre.rpg.state;

import java.awt.*;

public interface State {
    void init();
    void update();
    void render(Graphics graphics);
}
