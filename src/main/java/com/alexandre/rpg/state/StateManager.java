package com.alexandre.rpg.state;

import java.awt.*;

/**
 * Manage the current state and the transition between them
 */
public class StateManager {
    private State _currentState;

    public StateManager() {
        _currentState = new GameState();
    }

    public void changeCurrentState(State newState) {
        _currentState = newState;
    }

    public void updateCurrentState() {
        _currentState.update();
    }

    public void renderCurrentState(Graphics graphics) {
        _currentState.render(graphics);
    }

}
