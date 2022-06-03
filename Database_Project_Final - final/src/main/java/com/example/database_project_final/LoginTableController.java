package com.example.database_project_final;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class LoginTableController implements ILoginTableController{


         private TextField  tf_loginId_login;
         private TextField tf_userId_login;
         private TextField   tf_username_login;
          private TextField tf_password_login;
         private Button btn_insertlogin;
         private   Button btn_deletelogin;
          private Button btn_showlogin;
         private Button btn_searchlogin;
         private Button btn_updatelogin;
         private TextArea ta_show_login;

    public LoginTableController(TextField tf_loginId_login, TextField tf_userId_login, TextField tf_username_login, TextField tf_password_login, TextArea ta_show_login) {
        this.tf_loginId_login = tf_loginId_login;
        this.tf_userId_login = tf_userId_login;
        this.tf_username_login = tf_username_login;
        this.tf_password_login = tf_password_login;
        this.ta_show_login = ta_show_login;
    }

    public LoginTableController(TextField tf_loginId_login, TextField tf_userId_login, TextField tf_username_login,
                                TextField tf_password_login, Button btn_insertlogin, Button btn_deletelogin,
                                Button btn_showlogin, Button btn_searchlogin, Button btn_updatelogin, TextArea ta_show_login) {
        this.tf_loginId_login = tf_loginId_login;
        this.tf_userId_login = tf_userId_login;
        this.tf_username_login = tf_username_login;
        this.tf_password_login = tf_password_login;
        this.btn_insertlogin = btn_insertlogin;
        this.btn_deletelogin = btn_deletelogin;
        this.btn_showlogin = btn_showlogin;
        this.btn_searchlogin = btn_searchlogin;
        this.btn_updatelogin = btn_updatelogin;
        this.ta_show_login = ta_show_login;
    }

    @Override
    public void insertInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        LoginDao logindao = new LoginDao();
        logindao.insertInParyalLogin(a);
        cleanLoginTable();
        showFromParyalLogin();

    }

    @Override
    public void updateInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        LoginDao logindao = new LoginDao();
        logindao.updateInParyalLogin(a);
        cleanLoginTable();
        showFromParyalLogin();

    }

    @Override
    public void deleteInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        LoginDao logindao = new LoginDao();
        logindao.deleteInParyalLogin(a);
        cleanLoginTable();
        showFromParyalLogin();
    }

    @Override
    public void searchInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException {
        cleanLoginTable();
       LoginDao logindao = new LoginDao();
        a = logindao.searchInParyalLogin(a);
        tf_loginId_login.setText(String.valueOf(a.getLoginId()));
        tf_username_login.setText(a.getUsername());
        tf_password_login.setText(a.getPassword());
        tf_userId_login.setText(String.valueOf(a.getUserId()));
        System.out.println("whats going on, hee");

    }

    @Override
    public void showFromParyalLogin() throws ClassNotFoundException, SQLException, FileNotFoundException {
        cleanLoginTable();
        LoginDao logindao = new LoginDao();
        List<Login> loginlist = logindao.showParyalLogin();
        ta_show_login.setText("");

        StringBuffer buffer = new StringBuffer("loginId\t\tusername\t\t\t\tpasssword\t\tuserId\n");
        for ( Login a :loginlist){
            buffer.append(a.getLoginId()+"\t\t\t"+a.getUsername()+"\t\t\t\t\t\t"+a.getPassword()+"\t\t\t"+a.getUserId()+"\n");
        }
        ta_show_login.setText(buffer.toString());




    }
    public void cleanLoginTable(){
        tf_loginId_login.setText("");
        tf_password_login.setText("");
        tf_username_login.setText("");
        tf_userId_login.setText("");



    }
}
