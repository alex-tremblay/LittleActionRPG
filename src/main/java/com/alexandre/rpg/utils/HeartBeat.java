package com.alexandre.rpg.utils;

import com.alexandre.rpg.state.StateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * The heart of this game, loop a lot of time per second to calculate all things!
 */
public class HeartBeat extends Panel implements Runnable  {

    private final int MS_PER_UPDATE = 60;
    private boolean _isBeating;
    private Thread _thread;
    private StateManager _stateManager;
    private GameWindow _gameWindow;

    public HeartBeat() {
        _isBeating = false;
    }

    /**
     * Start the loop with it's thread
     */
    public synchronized void startBeating() {
        _thread = new Thread(this);
        _thread.start();
        _isBeating = true;
    }

    /**
     * Stop the loop
     */
    private synchronized void stopBeating() {
        _isBeating = false;
    }

    /**
     * The main game loop!
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 30.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;

        init();

        while (_isBeating) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                _stateManager.updateCurrentState();

                updates++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                System.out.println("FPS="+ frames +" UPS=" + updates);
                timer += 1000;
                frames = 0;
                updates = 0;
            }
        }
    }

    /**
     * Initialization of required object/variable
     */
    private void init() {
        _stateManager = new StateManager();
        _gameWindow = GameWindow.getInstance();
        _gameWindow.createWindow(this);
    }

    /**
     * Use or create a buffer to remove lag from rendering to the screen and pass it to the state manager
     */
    private void render() {
        BufferStrategy bufferStrategy = _gameWindow.getFrame().getBufferStrategy();
        if (bufferStrategy == null) {
            _gameWindow.getFrame().createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        _stateManager.renderCurrentState(graphics);

        bufferStrategy.show();
        graphics.dispose();
    }
}
