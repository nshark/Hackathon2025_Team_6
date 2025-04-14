package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui implements ActionListener {
    private final Canvas canvas;
    public Graphics2D g;
    private JButton button;
    public JTextField textArea;
    public boolean buttonPressed = false;
    public gui(){
        JFrame jFrame = new JFrame("Hackathon Project");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());
        canvas = new Canvas();
        mainPanel.add(canvas);
        jFrame.add(mainPanel, BorderLayout.CENTER);
        jFrame.add(inputPanel, BorderLayout.SOUTH);
        button = new JButton("Enter");
        button.addActionListener(this);
        textArea = new JTextField();
        inputPanel.add(textArea, BorderLayout.CENTER);
        inputPanel.add(button, BorderLayout.EAST);
        jFrame.setSize(1024,1024);
        jFrame.setVisible(true);
        jFrame.requestFocus();
        canvas.createBufferStrategy(2);
        g = (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();
        g.clearRect(0, 0, 500, 500);
    }
    public void update(){
        canvas.getBufferStrategy().show();
        canvas.update(g);
        g.dispose();
        g = (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();
        g.clearRect(0, 0, 500, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonPressed = true;
    }
}