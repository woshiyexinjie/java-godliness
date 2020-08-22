package com.helloxin.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;


public class LineDemo {
    public static class Main extends Application {
        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Drawing Lines");

            Group root = new Group();
            Scene scene = new Scene(root, 300, 150, Color.GRAY);

            Line redLine = new Line(10, 10, 200, 10);

            redLine.setStroke(Color.RED);
            redLine.setStrokeWidth(10);
            redLine.setStrokeLineCap(StrokeLineCap.BUTT);

            redLine.getStrokeDashArray().addAll(15d, 5d, 15d, 15d, 20d);
            redLine.setStrokeDashOffset(10);

            root.getChildren().add(redLine);

            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
