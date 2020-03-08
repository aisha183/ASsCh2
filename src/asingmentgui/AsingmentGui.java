/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asingmentgui;

import java.util.stream.Collectors;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class AsingmentGui extends Application {

    private ListView<String> listViewNames;
    private ListView<String> listViewCopy;
    private TextField textFieldName;
    private Button buttonCopy;

    HBox hBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        listViewNames = new ListView<>();
        listViewNames.getItems().addAll("Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green");
        listViewNames.setPadding(new Insets(20, 20, 15, 15));
        listViewNames.setPrefSize(200, 30);

        buttonCopy = new Button("Copy >>>");
        buttonCopy.setPadding(new Insets(10, 10, 10, 15));

        listViewCopy = new ListView<>();
        listViewCopy.setPadding(new Insets(20, 20, 15, 15));
        listViewCopy.setPrefSize(200, 30);

        listViewNames.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Alert a = new Alert(AlertType.ERROR);
        buttonCopy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (listViewNames.getSelectionModel().isEmpty()) {
                    a.setAlertType(AlertType.ERROR);

                    a.show();
                } else {
                    listViewCopy.getItems().addAll(listViewNames.getSelectionModel().getSelectedItems());

                    listViewCopy.getItems().setAll(
                            listViewCopy.getItems().stream()
                                    .sorted()
                                    .collect(Collectors.toList()));
                }
            }
        });

        hBox = new HBox(30, listViewNames, buttonCopy, listViewCopy);
        hBox.setAlignment(Pos.CENTER_LEFT);
        Scene scene = new Scene(hBox, 500, 250);

        primaryStage.setTitle("multiple-selection lists ");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
