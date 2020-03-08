/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
class NewStage1 {

    private static final long serialVersionUID = 1L;

    NewStage1() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Stage subStage = new Stage();
        subStage.setTitle("Option Page");

        Button bAddStudent = new Button("Add Student");
        bAddStudent.setPadding(new Insets(10, 20, 10, 20));

        Button bViewStudent = new Button("View Student");
        bViewStudent.setPadding(new Insets(10, 20, 10, 20));
        VBox vbox1 = new VBox(bAddStudent, bViewStudent);

        VBox hbBtn = new VBox(15);
        hbBtn.getChildren().addAll(bAddStudent, bViewStudent);
        grid.add(hbBtn, 1, 8);

        Scene scene = new Scene(grid, 500, 400);
        scene.getStylesheets().add(getClass().getResource("newStyle.css").toExternalForm());

        subStage.setScene(scene);
        subStage.show();
    }
}

public class fin extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        Button edit = new Button("Edit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        hbBtn.getChildren().addAll(btn, edit);

        grid.add(hbBtn, 1, 4);
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("newStyle.css").toExternalForm());
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if(userTextField.getText().equalsIgnoreCase("Aisha")){
                 new NewStage1();
                }
                 actiontarget.setFill(Color.FIREBRICK);
                 actiontarget.setText("Sign in button pressed");
            }
        });
    }

    public static void main(String[] args) {

        Application.launch(args);
    }

}
