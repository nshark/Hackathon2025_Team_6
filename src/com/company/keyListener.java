package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class keyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        HandleKeyEvent(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        HandleKeyEvent(e, false);
    }

    private void HandleKeyEvent(KeyEvent e, boolean on) {

    }
}
