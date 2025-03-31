package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Input field for user input
        TextField inputField = new TextField();
        inputField.setPromptText("Enter value");

        // Dropdown for selecting conversion type
        ComboBox<String> conversionType = new ComboBox<>();
        conversionType.getItems().addAll(
                "Kilometers to Miles",
                "Miles to Kilometers",
                "Celsius to Fahrenheit",
                "Fahrenheit to Celsius",
                "Kilograms to Pounds",
                "Pounds to Kilograms"
        );
        conversionType.setValue("Kilometers to Miles"); // Default selection

        // Convert button
        Button convertButton = new Button("Convert");

        // Label to show result
        Label resultLabel = new Label("Result: ");

        // Event handling for conversion
        convertButton.setOnAction(event -> {
            try {
                double inputValue = Double.parseDouble(inputField.getText());
                String selectedConversion = conversionType.getValue();
                double convertedValue = convert(inputValue, selectedConversion);
                resultLabel.setText("Result: " + convertedValue);
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a number.");
            }
        });

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(inputField, 0, 0, 2, 1);
        grid.add(conversionType, 0, 1, 2, 1);
        grid.add(convertButton, 0, 2, 2, 1);
        grid.add(resultLabel, 0, 3, 2, 1);

        // Scene setup
        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Conversion logic
    private double convert(double value, String conversionType) {
        return switch (conversionType) {
            case "Kilometers to Miles" -> value * 0.621371;
            case "Miles to Kilometers" -> value / 0.621371;
            case "Celsius to Fahrenheit" -> (value * 9 / 5) + 32;
            case "Fahrenheit to Celsius" -> (value - 32) * 5 / 9;
            case "Kilograms to Pounds" -> value * 2.20462;
            case "Pounds to Kilograms" -> value / 2.20462;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
