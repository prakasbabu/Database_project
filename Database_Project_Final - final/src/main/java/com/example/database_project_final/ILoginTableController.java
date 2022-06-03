package com.example.database_project_final;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface ILoginTableController {
    public void insertInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void updateInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void deleteInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void searchInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void showFromParyalLogin() throws ClassNotFoundException, SQLException, FileNotFoundException;
}
