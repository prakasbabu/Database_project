package com.example.database_project_final;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.database_project_final.LoginController.changeScene;

public class MainController implements Initializable {
    @FXML
    private TextField tf_user_Id_user;
    @FXML
    private TextField tf_first_Name_user;
    @FXML
    private TextField tf_last_Name_user;
    @FXML
    private TextField tf_email_Address_user;
    @FXML
    private TextField tf_access_Level_user;
    @FXML
    private Button btn_search_user;
    @FXML
    private Button btn_insert_user;
    @FXML
    private Button btn_update_user;
    @FXML
    private Button btn_delete_user;
    @FXML
    private Button btn_show_user;
    @FXML
    private TextArea ta_show_user;

    @FXML
    private Button btn_logout;
    @FXML
    private TextField  tf_loginId_login;
    @FXML
    private TextField tf_userId_login;
    @FXML
    private TextField   tf_username_login;
    @FXML
    private TextField tf_password_login;
    @FXML
    private Button btn_insertlogin;
    @FXML
    private   Button btn_deletelogin;
    @FXML
    private Button btn_showlogin;
    @FXML
    private Button btn_searchlogin;
    @FXML
    private Button btn_updatelogin;
    @FXML
    private TextArea ta_show_login;


    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                changeScene(actionEvent, "login.fxml", null, null, null);

            }
        });
    }


    @FXML
    public void searchParyalLogin(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();

        if (cmd.contains("Search") && tf_userId_login.getText().isEmpty()) {
            System.out.println("login id is empty");
            System.out.println(tf_userId_login);
            System.out.println(cmd);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("put login id to search");
            alert.showAndWait();
        } else {
            LoginTableController loginTableController = new LoginTableController(tf_loginId_login,  tf_username_login,
                    tf_password_login, tf_userId_login,ta_show_login);
            loginTableController.showFromParyalLogin();
            System.out.println(" ok i am searching");

        }

    }

    @FXML
    public void insertInParyalLogin(ActionEvent actionEvent) throws SQLException, FileNotFoundException,NumberFormatException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        System.out.println(cmd);
        LoginTableController loginTableController = new LoginTableController(tf_loginId_login,  tf_username_login,
                tf_password_login,tf_userId_login, ta_show_login);

        if ((cmd.contains("Insert") ) &&

                ( tf_loginId_login.getText().isEmpty()||tf_userId_login.getText().isEmpty()
                        ||tf_username_login.getText().isEmpty()
                        ||tf_password_login.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
        }else{
            Login login = new Login();
            login.setLoginId(Integer.parseInt(tf_loginId_login.getText()));
            login.setUsername(tf_username_login.getText());
            login.setPassword(tf_password_login.getText());
            login.setUserId(Integer.parseInt(tf_userId_login.getText()));
            loginTableController.insertInParyalLogin(login);
        }


    }

    @FXML
    public void updateInParyalLogin(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        LoginTableController loginTableController = new LoginTableController(tf_loginId_login, tf_username_login,
                tf_password_login,tf_userId_login, ta_show_login);
        if ((cmd.contains("Update") ) &&
                (tf_loginId_login.getText().isEmpty()
                        ||tf_userId_login.getText().isEmpty()
                        ||tf_password_login.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
        }else{
            Login login = new Login();
            login.setLoginId(Integer.parseInt(tf_loginId_login.getText().trim()));
            login.setUsername(tf_username_login.getText());
            login.setPassword(tf_password_login.getText());
            login.setUserId(Integer.parseInt(tf_userId_login.getText()));
            loginTableController.updateInParyalLogin(login);

        }

    }

    @FXML
    public void deleteInParyalLogin(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        LoginTableController loginTableController = new LoginTableController(tf_loginId_login,  tf_username_login,
                tf_password_login, tf_userId_login,ta_show_login);
        if ( (cmd.contains("Delete") /*|| cmd.contains("tf_loginid_login")*/ ) && tf_loginId_login.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Put Login Id To delete");
            alert.showAndWait();
        }else {
            Login login = new Login();
            login.setLoginId(Integer.parseInt(tf_loginId_login.getText()));
            login.setUsername("");
            login.setPassword("");
           // login.setUserId(Integer.parseInt(" "));
            loginTableController.cleanLoginTable();
            loginTableController.deleteInParyalLogin(login);


        }


    }

    @FXML
    public void showFromParyalLogin(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        LoginTableController loginTableController = new LoginTableController(tf_loginId_login,  tf_username_login,
                tf_password_login, tf_userId_login, ta_show_login);
        if (cmd.contains("show"))
            loginTableController.showFromParyalLogin();


    }

    @FXML
    public void searchParyalUser(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();

        if (cmd.contains("Search") && tf_user_Id_user.getText().isEmpty()) {
            System.out.println("text field is not empty");
            System.out.println(tf_user_Id_user);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
        } else {
            UserTableController userTableController = new UserTableController(tf_user_Id_user, tf_first_Name_user, tf_last_Name_user,
                    tf_email_Address_user, tf_access_Level_user, ta_show_user);
            userTableController.showFromParyalUser();
            System.out.println(" did you search");

        }
    }

    @FXML
    public void insertInParyalUser(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        System.out.println(cmd);
        UserTableController userTableController = new UserTableController(tf_user_Id_user,tf_first_Name_user,tf_last_Name_user,
                tf_email_Address_user,tf_access_Level_user,ta_show_user);

        if ((cmd.contains("Insert") ) &&
       (tf_user_Id_user.getText().isEmpty()
       ||tf_first_Name_user.getText().isEmpty()
       ||tf_last_Name_user.getText().isEmpty()
       ||tf_email_Address_user.getText().isEmpty()
       ||tf_access_Level_user.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
        }else{
            User user = new User();
            user.setUserId(Integer.parseInt(tf_user_Id_user.getText()));
            user.setFirstName(tf_first_Name_user.getText());
            user.setLastName(tf_last_Name_user.getText());
            user.setEmailAddress(tf_email_Address_user.getText());
            user.setAccessLevel(tf_access_Level_user.getText());
            userTableController.insertInParyalUser(user);
        }



    }

    @FXML
    public void updateInParyalUser(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
       String cmd = actionEvent.getSource().toString();
        //System.out.println(cmd);
        UserTableController userTableController = new UserTableController(tf_user_Id_user,tf_first_Name_user,tf_last_Name_user,tf_email_Address_user,
                tf_access_Level_user,ta_show_user);
        if ((cmd.contains("Update") ) &&
                (tf_user_Id_user.getText().isEmpty()
                        ||tf_first_Name_user.getText().isEmpty()
                        ||tf_last_Name_user.getText().isEmpty()
                        ||tf_email_Address_user.getText().isEmpty()
                        ||tf_access_Level_user.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
        }else{
            User user = new User();
            user.setUserId(Integer.parseInt(tf_user_Id_user.getText()));
            user.setFirstName(tf_first_Name_user.getText());
            user.setLastName(tf_last_Name_user.getText());
            user.setEmailAddress(tf_email_Address_user.getText());
            user.setAccessLevel(tf_access_Level_user.getText());
            userTableController.updateInParyalUser(user);
        }


    }

    @FXML
    public void deleteInParyalUser(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        UserTableController userTableController = new UserTableController(tf_user_Id_user,tf_first_Name_user,tf_last_Name_user,
                tf_email_Address_user,tf_access_Level_user,ta_show_user);

        if ( (cmd.contains("Delete") || cmd.contains("tf_user_Id_user") ) && tf_user_Id_user.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Put User Id To delete");
            alert.showAndWait();
        }else {
            User user = new User();

            user.setUserId(Integer.parseInt(tf_user_Id_user.getText()));
            user.setFirstName("");
            user.setLastName("");
            user.setEmailAddress("");
            user.setAccessLevel("");
            userTableController.cleanUserTable();
            userTableController.deleteInParyalUser(user);


        }


    }

    @FXML
    public void showfromParyalUser(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
       String cmd = actionEvent.getSource().toString();
        UserTableController userTableController = new UserTableController(tf_user_Id_user,tf_first_Name_user,tf_last_Name_user,
                tf_email_Address_user,tf_access_Level_user,ta_show_user);
        if (cmd.contains("show"))
        userTableController.showFromParyalUser();

    }
/*
    @FXML
    public void actionOnUserTable(ActionEvent actionEvent) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String cmd = actionEvent.getSource().toString();
        System.out.println(cmd);
        UserTableController userTableController = new UserTableController(tf_user_Id_user, tf_first_Name_user, tf_last_Name_user,
                tf_email_Address_user, tf_access_Level_user, ta_show_user);

        if ((cmd.contains("Insert") || cmd.contains("Update")) &&
                (tf_user_Id_user.getText().isEmpty()
                        || tf_first_Name_user.getText().isEmpty()
                        || tf_last_Name_user.getText().isEmpty()
                        || tf_email_Address_user.getText().isEmpty()
                        || tf_access_Level_user.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
        }else{
            if ( (cmd.contains("Delete") || cmd.contains("Search") || cmd.contains("tf_user_Id_user") &&
                    tf_user_Id_user.getText().isEmpty())){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Warning Message");
                alert.setHeaderText(null);
                alert.setContentText("All fields must be filled");
                alert.showAndWait();
            } else{
                try{
                    if (cmd.contains("Show")){
                        userTableController.showFromParyalUser();
                        System.out.println("showing");
                    }else {
                        User user = new User();
                        user.setUserId(Integer.parseInt(tf_user_Id_user.getText()));
                        System.out.println(tf_user_Id_user);
                        user.setFirstName(tf_first_Name_user.getText());
                        user.setLastName(tf_last_Name_user.getText());
                        user.setEmailAddress(tf_email_Address_user.getText());
                        user.setAccessLevel(tf_access_Level_user.getText());
                        userTableController.updateInParyalUser(user);
                        if ( cmd.contains("Insert")){
                            userTableController.insertInParyalUser(user);
                            System.out.println("inserting");
                        }else if (cmd.contains("Update")){
                            userTableController.updateInParyalUser(user);
                            System.out.println("updating");

                        }else if(cmd.contains("Delete")){
                            userTableController.deleteInParyalUser(user);
                            System.out.println("deleting");
                        }else if (cmd.contains(" Search") || cmd.contains("tf_user_Id_user")){
                            userTableController.showFromParyalUser();
                            System.out.println("searching");
                        }
                    }
                }catch(SQLException e){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Warning Message");
                    alert.setHeaderText(null);
                    alert.setContentText("All fields must be filled");
                    alert.showAndWait();
                }
            }
        }


    }*/

}