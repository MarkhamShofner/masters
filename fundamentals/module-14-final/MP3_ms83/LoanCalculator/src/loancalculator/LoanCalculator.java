/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loancalculator;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

/**
 * This project involves implementing a Java program that performs a calculation of payments associated
with loans. The program shall allow a user to enter the following data: annual interest rate, the term of
the loan (i.e., number of years), and the loan amount.
 * @author mark8604
 */
public class LoanCalculator extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    // Override the start() method.
    public void start(Stage myStage) {
      // Give the stage a title.
      myStage.setTitle("Loan Calculator");
      // Use a FlowPane for the root node.
      GridPane rootNode = new GridPane();
      // Create a scene.
      Scene myScene = new Scene(rootNode, 350, 200);
      // Set the scene on the stage.
      myStage.setScene(myScene);

  //    rootNode.setPadding(25, 25, 25, 25);
      rootNode.setHgap(10);

      Label annualInterestRate = new Label("Annual Interest Rate:");
      rootNode.add(annualInterestRate, 0, 1);
      TextField annualInterestRateVal = new TextField();
      rootNode.add(annualInterestRateVal, 1, 1);

      Label numberYears = new Label("Number of Years:");
      rootNode.add(numberYears, 0, 2);
      TextField numberYearsVal = new TextField();
      rootNode.add(numberYearsVal, 1, 2);

      Label loanAmount = new Label("Loan Amount:");
      rootNode.add(loanAmount, 0, 3);
      TextField loanAmountVal = new TextField();
      rootNode.add(loanAmountVal, 1, 3);

      Label monthlyPayment = new Label("Monthly Payment:");
      rootNode.add(monthlyPayment, 0, 4);
      TextField monthlyPaymentVal = new TextField();
      rootNode.add(monthlyPaymentVal, 1, 4);

      Label totalPayment = new Label("Total Payment:");
      rootNode.add(totalPayment, 0, 5);
      TextField totalPaymentVal = new TextField();
      rootNode.add(totalPaymentVal, 1, 5);

      Button btn = new Button("Calculate");
      rootNode.add(btn, 1, 6);

      // Handle the action event for the calculate button
      btn.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
            double annualInterestRate = Double.parseDouble(annualInterestRateVal.getText());
            double numberYears = Double.parseDouble(numberYearsVal.getText());
            double loanAmount = Double.parseDouble(loanAmountVal.getText());

            double periodicInterestRate = annualInterestRate/12;
            double monthlyPayment = ((periodicInterestRate*loanAmount)/(1-Math.pow(1+periodicInterestRate, -12*numberYears)));
            double totalPayment = monthlyPayment * 12 * numberYears;
            monthlyPaymentVal.setText(Double.toString(monthlyPayment));
            totalPaymentVal.setText(Double.toString(totalPayment));
        }
      });

      // Show the stage and its scene.
      myStage.show();
    }

}
