/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import static java.lang.Integer.parseInt;
import java.text.DecimalFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class temperatureConversion extends Application {
    
    private VBox vBox;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label nameLabel = new Label("Enter  Celsius temperature *_*");
        Label nameLabe2 = new Label("New Temperature :");
        nameLabel.setPadding(new Insets(30, 15, 10, 15));
        
        TextField textField = new TextField();
        textField.setPrefSize(20, 20);
        textField.setPadding(new Insets(5, 15, 5, 15));
        
        RadioButton rb1 = new RadioButton("Fahrenheit ");
        RadioButton rb2 = new RadioButton("Kelvin ");
        
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb1.setOnAction(event ->{
        double toNum = Double.parseDouble(textField.getText());
        if (rb1.isSelected()) {
            double celsiusResult = (toNum * 5 / 9) + 32;
            nameLabe2.setText("New Temperture is : " + new DecimalFormat("##.##").format(celsiusResult) + "F");
        } else {
            double fahernheitResult = toNum + 273.15;
            nameLabe2.setText("New Temperture is : " + new DecimalFormat("##.##").format(fahernheitResult) + "K");
        }
        });
        
        rb2.setOnAction(event ->{
        double toNum = Double.parseDouble(textField.getText());
        if (rb1.isSelected()) {
            double celsiusResult = (toNum * 5 / 9) + 32;
            nameLabe2.setText("New Temperture is : " + new DecimalFormat("##.##").format(celsiusResult) + "F");
        } else {
            double fahernheitResult = toNum + 273.15;
            nameLabe2.setText("New Temperture is : " + new DecimalFormat("##.##").format(fahernheitResult) + "K");
        }
        });
        
        HBox hBox = new HBox(10, rb1, rb2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(50);
        
        vBox = new VBox(nameLabel, textField, hBox, nameLabe2);
        vBox.setAlignment(Pos.TOP_CENTER);
        
        Scene scene = new Scene(vBox, 500, 250);
        primaryStage.setTitle("emperature-conversion");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
