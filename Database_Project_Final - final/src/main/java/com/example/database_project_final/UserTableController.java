package com.example.database_project_final;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class UserTableController implements IUserTableController {
    private TextField tf_user_Id_user;
    private TextField tf_first_Name_user;
    private TextField   tf_last_Name_user;
    private TextField  tf_email_Address_user;
    private TextField tf_access_Level_user;
    private Button btn_search_user;
    private Button   btn_insert_user;
    private Button    btn_update_user;
    private Button    btn_delete_user;
    private Button      btn_show_user;
    private TextArea ta_show_user;


    public UserTableController(TextField tf_user_Id_user, TextField tf_first_Name_user, TextField tf_last_Name_user,
                               TextField tf_email_Address_user, TextField tf_access_Level_user, TextArea ta_show_user) {
        this.tf_user_Id_user = tf_user_Id_user;
        this.tf_first_Name_user = tf_first_Name_user;
        this.tf_last_Name_user = tf_last_Name_user;
        this.tf_email_Address_user = tf_email_Address_user;
        this.tf_access_Level_user = tf_access_Level_user;
        this.btn_search_user = btn_search_user;
        this.btn_insert_user = btn_insert_user;
        this.btn_update_user = btn_update_user;
        this.btn_delete_user = btn_delete_user;
        this.btn_show_user = btn_show_user;
        this.ta_show_user = ta_show_user;
    }

    @Override
    public void insertInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException {

        UserDao userdao = new UserDao();
        userdao.insertInParyalUser(a);
        cleanUserTable();
        showFromParyalUser();

    }

    @Override
    public void updateInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        UserDao userdao = new UserDao();
        userdao.updateInParyalUser(a);
        cleanUserTable();
        showFromParyalUser();

    }

    @Override
    public void deleteInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        UserDao userdao = new UserDao();
        userdao.deleteInParyalUser(a);
        cleanUserTable();
        showFromParyalUser();
    }

    @Override
    public void searchInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        cleanUserTable();
        UserDao userdao = new UserDao();
        a = userdao.searchInParyalUser(a);
        tf_user_Id_user.setText(String.valueOf(a.getUserId()));
        tf_first_Name_user.setText(a.getFirstName());
        tf_last_Name_user.setText(a.getLastName());
        tf_email_Address_user.setText(a.getEmailAddress());
        tf_access_Level_user.setText(a.getAccessLevel());
        System.out.println("why this is not being printed ");

    }


    @Override
    public void showFromParyalUser() throws ClassNotFoundException, SQLException, FileNotFoundException {
        cleanUserTable();
        UserDao userdao = new UserDao();
        ta_show_user.setText("");
        List<User> users = userdao.showParyalUsers();
        StringBuffer buffer = new StringBuffer("userId\t\t\t\tfirstName\t\t\t\tlastName\t\t\t\temailAddress\t\t\taccessLevel\n");
        for ( User a :users){
            buffer.append(a.getUserId()+"\t\t\t\t\t"+a.getFirstName()+"\t\t\t\t\t"+a.getLastName()+"\t\t\t\t"+
                    "\t\t"+a.getEmailAddress()+"\t\t\t\t\t"+a.getAccessLevel()+"\n");

        }
        ta_show_user.setText(buffer.toString());


    }

    public void cleanUserTable(){
        tf_user_Id_user.setText("");
        tf_first_Name_user.setText("");
        tf_last_Name_user.setText("");
        tf_email_Address_user.setText("");
        tf_access_Level_user.setText("");


    }


}
