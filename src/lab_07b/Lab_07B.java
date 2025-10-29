/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_07b;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Jacques-Conrad Calagui-Painchaud 6298805
 * 2025/10/29
 */
public class Lab_07B extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Button playPauseButton = new Button("Play ");
        
        playPauseButton.setOnMouseClicked(e -> {
            if (playPauseButton.getText().equals("Play")) {
                playPauseButton.setText("Pause");
                // TODO: Add implementation of play and pause
            } else {
                playPauseButton.setText("Play");
            }
        });
        
        Button speedIncreaseButton = new Button("Speed +");
        
        speedIncreaseButton.setOnMouseClicked(e -> {
            // TODO: Add implementation
        });
        
        Button speedDecreaseButton = new Button("Speed -");
        
        speedDecreaseButton.setOnMouseClicked(e -> {
            // TODO: Add implementation
        });
        
        HBox buttonBar = new HBox(playPauseButton, speedIncreaseButton, speedDecreaseButton);
        buttonBar.setAlignment(Pos.CENTER);
        
        BorderPane root = new BorderPane();
        root.setBottom(buttonBar);
        
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
