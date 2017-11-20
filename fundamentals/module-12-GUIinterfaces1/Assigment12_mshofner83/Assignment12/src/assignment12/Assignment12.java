/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * building a GUI interface for a simple calculator using Java FX
 * @author mark8604
 */
public class Assignment12 extends Application {
  public static void main(String[] args) {
    // Start the JavaFX application by calling launch().
    launch(args);
  }
  // Override the start() method.
  public void start(Stage myStage) {
    // Give the stage a title.
    myStage.setTitle("Simple Calculator");
    // Use a FlowPane for the root node.
    GridPane rootNode = new GridPane();
    // Create a scene.
    Scene myScene = new Scene(rootNode, 300, 200);
    // Set the scene on the stage.
    myStage.setScene(myScene);
    
//    rootNode.setPadding(25, 25, 25, 25);
    rootNode.setHgap(10);

    Label firstVal = new Label("First Value:");
    rootNode.add(firstVal, 0, 1);
    TextField firstValField = new TextField();
    rootNode.add(firstValField, 1, 1);

    Label secondVal = new Label("Second Value:");
    rootNode.add(secondVal, 0, 2);
    TextField secondValField = new TextField();
    rootNode.add(secondValField, 1, 2);

    Label sum = new Label("Sum is:");
    rootNode.add(sum, 0, 3);
    TextField sumBox = new TextField();
    rootNode.add(sumBox, 1, 3);

    Button btn = new Button("Calculate");
    rootNode.add(btn, 1, 4);

    // Show the stage and its scene.
    myStage.show();
  }
}
