package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class gui implements ActionListener {
    private final Canvas canvas;
    public Graphics2D g;
    private JButton button;
    public JTextField textArea;
    public boolean buttonPressed = false;

    // This color will be updated based on the weather
    private Color backgroundColor = Color.WHITE;

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

        // Double-buffering
        canvas.createBufferStrategy(2);
        g = (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();
        g.clearRect(0, 0, 500, 500);

        // Fetch weather and apply background right away
        applyWeatherBackground(); // or any other city of your choice
    }

    public void update(){
        canvas.getBufferStrategy().show();
        canvas.update(g);
        g.dispose();
        g = (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();

        // Clear the entire canvas with the chosen background color
        g.setBackground(backgroundColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonPressed = true;
    }

    /**
     * Fetches the current weather for the specified city and updates the background color
     * based on the weather condition. Uses a naive approach to parse JSON— in a real
     * scenario, use something like org.json or Gson to parse properly.
     */
    private void applyWeatherBackground() {
        try {
            // Build the request URL. Example with OpenWeatherMap:
            String endpoint = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s",
                    "Boston", "1e37b1d051111ab487299ea77283e8a8" // <-- Replace with your real API key
            );

            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder responseBuf = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseBuf.append(inputLine);
            }
            in.close();

            // A simple (very naive) parsing approach to find something like: "main":"Rain"
            // In production, use a real JSON library
            String response = responseBuf.toString();
            String weatherSection = "\"main\":\"";
            int index = response.indexOf(weatherSection);
            if (index != -1) {
                int start = index + weatherSection.length();
                int end = response.indexOf("\"", start);
                if (end != -1) {
                    String weather = response.substring(start, end);
                    // Convert to lowercase for consistency
                    weather = weather.toLowerCase(Locale.ROOT);

                    // Decide background color based on weather
                    if (weather.contains("rain")) {
                        backgroundColor = new Color(135, 206, 235); // Light sky blue for "rainy"
                    } else if (weather.contains("cloud")) {
                        backgroundColor = new Color(192, 192, 192); // Gray for "cloudy"
                    } else if (weather.contains("clear")) {
                        backgroundColor = new Color(255, 215, 0);   // Golden for "sunny/clear"
                    } else if (weather.contains("snow")) {
                        backgroundColor = Color.WHITE; // White for snow
                    } else {
                        backgroundColor = Color.LIGHT_GRAY; // Default color
                    }
                }
            }
            con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            // If for some reason the API call fails or parse fails, pick default background color
            backgroundColor = Color.LIGHT_GRAY;
        }
    }
}
