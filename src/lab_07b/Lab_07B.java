/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_07b;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jacques-Conrad Calagui-Painchaud 6298805
 * 2025/10/29
 * https://github.com/waffleprinter/Lab_07B.git
 */
public class Lab_07B extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Image[] images = new Image[20];
        
        for (int i = 0; i < 20 ; i++) {
            images[i] = new Image("file:images/" + (i + 101) + ".jpg");
        }
        
        Label imageLabel = new Label();
        imageLabel.setGraphic(new ImageView(images[0]));
        
        int[] frameIndex = {0};
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setOnFinished(e -> {
            frameIndex[0] = (frameIndex[0] + 1) % 20;
            imageLabel.setGraphic(new ImageView(images[frameIndex[0]]));
        });
        
        SequentialTransition sequentialTransition = new SequentialTransition(imageLabel, fadeTransition);
        sequentialTransition.setCycleCount(Animation.INDEFINITE);
        
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
        root.setTop(imageLabel);
        
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
