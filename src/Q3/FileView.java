/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.xml.ws.Action;

/**
 *
 * @author PC
 */
public class FileView extends Application {

    Scene scene, scene1;
    Stage primaryStage;
    Stage primaryStage1;

    TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final double WIDTH = 600.0, HEIGHT = 350.0;
        MenuBar menubar = new MenuBar();

        Menu fileMenu = new Menu("_File");
        MenuItem openItem = new MenuItem("_Open");
        MenuItem closeItem = new MenuItem("_Close");
        MenuItem exitItem = new MenuItem("_Exit");
        fileMenu.getItems().addAll(openItem, closeItem, exitItem);

        Menu editMenu = new Menu("_Edit");
        MenuItem fontItem = new MenuItem("_Font");
        MenuItem colorItem = new MenuItem("_Color");
        editMenu.getItems().addAll(fontItem, colorItem);
        menubar.getMenus().addAll(fileMenu, editMenu);

        textArea = new TextArea();
        EventHundler1 e1 = new EventHundler1();
        openItem.setOnAction(e1);
        exitItem.setOnAction(e1);
        colorItem.setOnAction(e1);
        fontItem.setOnAction(e1);
        closeItem.setOnAction(e1);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menubar);
        Pane vbox = new VBox(borderPane, textArea);
        scene = new Scene(vbox, WIDTH, HEIGHT);
        primaryStage.setTitle("File View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class EventHundler1 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String newItem = ((MenuItem) event.getSource()).getText();
            switch (newItem) {
                case "_Open":

                    try {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setInitialFileName(".");
                        File selectedFile = fileChooser.showOpenDialog(primaryStage);
                        Scanner s = new Scanner(selectedFile);
                        while (s.hasNext()) {
                            textArea.appendText(s.nextLine());

                        }

                        s.close();

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileView.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                case "_Close":
                    textArea.setText("");
                    break;

                case "_Exit":
                    System.exit(0);
                    break;

                case "_Font":
                    Dialog<Integer> dialogsize = new ChoiceDialog<>(10,12,14,16,18,20,22,24,26);
                    dialogsize.setHeaderText("Font");
                    int size = dialogsize.showAndWait().get();
                    textArea.setStyle("-fx-font-size:" + size + "px ;");

                    break;

                case "_Color":
                    Dialog<String> dialogColor = new ChoiceDialog<>("Black", "Red", "Blue", "Gray");
                    dialogColor.setHeaderText("Color");
                    String color = dialogColor.showAndWait().get();
                    textArea.setStyle("-fx-text-fill:" + color + ";");
                    break;
            }
            

        }

    }

}
