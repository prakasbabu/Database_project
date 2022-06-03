package com.example.database_project_final;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.database_project_final.LoginController.changeScene;

public class LoggedinController implements Initializable {

    @FXML
    private Label lbl_loggedin;


    @FXML
   private Button btn_logout;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                changeScene(actionEvent, "login.fxml", null, null, null);

            }
        });
    }


    public void logoutUser(ActionEvent actionEvent) {
    }
}
