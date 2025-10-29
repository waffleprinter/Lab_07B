/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_07b;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jacques-Conrad Calagui-Painchaud 6298805
 * 2025/10/29
 * https://github.com/waffleprinter/Lab_07B.git
 */
public class Lab_07B extends Application {
    private int frameIndex = 0;
    private double rate = 1;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // Create images array
        Image[] images = new Image[20];
        
        for (int i = 0; i < 20 ; i++) {
            images[i] = new Image("file:images/" + (i + 101) + ".jpg");
        }
        
        // Animation to cycle through images
        Label imageLabel = new Label();
        imageLabel.setGraphic(new ImageView(images[0]));
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(e -> {
            frameIndex = (frameIndex + 1) % 20;
            imageLabel.setGraphic(new ImageView(images[frameIndex]));
        });
        
        SequentialTransition sequentialTransition = new SequentialTransition(imageLabel, fadeTransition);
        sequentialTransition.setCycleCount(Animation.INDEFINITE);
        
        // Play-pause button allows to play when paused, and pause when playing
        Button playPauseButton = new Button("Play");
        
        playPauseButton.setOnMouseClicked(e -> {
            if (playPauseButton.getText().equals("Play")) {
                playPauseButton.setText("Pause");
                sequentialTransition.play();
            } else {
                playPauseButton.setText("Play");
                sequentialTransition.pause();
            }
        });
        
        // Speed increase/decrease buttons affect the length of each frame
        Button speedIncreaseButton = new Button("Speed +");
        
        speedIncreaseButton.setOnMouseClicked(e -> {
            if (rate < 5) {
                rate += 0.5;
            }
            
            sequentialTransition.setRate(rate);
        });
        
        Button speedDecreaseButton = new Button("Speed -");
        
        speedDecreaseButton.setOnMouseClicked(e -> {
            if (rate > 0.5) {
                rate -= 0.5;
            }
            
            sequentialTransition.setRate(rate);
        });
        
        // Buttons on the bottom, image in the center
        HBox buttonBar = new HBox(playPauseButton, speedIncreaseButton, speedDecreaseButton);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setPadding(new Insets(25));
        
        HBox imageContainer = new HBox(imageLabel);
        imageContainer.setAlignment(Pos.CENTER);
        
        BorderPane root = new BorderPane();
        root.setBottom(buttonBar);
        root.setCenter(imageContainer);
        
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}
