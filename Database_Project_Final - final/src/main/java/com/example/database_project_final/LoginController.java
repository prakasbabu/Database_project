package com.example.database_project_final;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private Button btn_signin;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    btn_signin.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            try {
               loginUser(actionEvent);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    });


    }

    /*public void loginUser(ActionEvent actionevent, String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement((" select password from paryallogin where username= ?"));
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if ( !resultSet.isBeforeFirst()){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(" No Username found");
                alert.show();
            }else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        DbConnection.changeScene(actionevent, "loggedin.fxml", null, null, "hi");

                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The credentials are incorrect");
                        alert.show();
                    }

                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
*/

    public void loginUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{

            preparedStatement = connection.prepareStatement((" select password from paryallogin where username= ?"));
            preparedStatement.setString(1, tf_username.getText());
            resultSet = preparedStatement.executeQuery();

            if ( !resultSet.isBeforeFirst()){
                System.out.println(" No usernamed found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(" No Username found");
                alert.show();
            }else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(tf_password.getText())) {
                        changeScene(actionEvent, "main.fxml", null, null, "database");
                        System.out.println("password did match");

                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The credentials are incorrect");
                        alert.show();
                    }

                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void changeScene(ActionEvent event, String fxmlFile, String username, String password, String title){

        Parent root = null;

        if ( username != null && password != null ){
            try{
                FXMLLoader loader = new FXMLLoader(DbConnection.class.getResource(fxmlFile));
                root = loader.load();
                LoggedinController loggedinController = loader.getController();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(DbConnection.class.getResource(fxmlFile));
            }catch(Exception e){
                e.printStackTrace();
            }

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 820,740));
            stage.show();

        }

    }
}
