package com.example.database_project_final;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface ILoginTable {
    public void insertInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void updateInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void deleteInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public Login searchInParyalLogin(Login a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public List<Login> showParyalLogin() throws  ClassNotFoundException, SQLException, FileNotFoundException;
}
