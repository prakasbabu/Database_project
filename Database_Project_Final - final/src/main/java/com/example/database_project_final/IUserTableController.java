package com.example.database_project_final;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface IUserTableController {
    public void insertInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void updateInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void deleteInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void searchInParyalUser(User a) throws ClassNotFoundException, SQLException, FileNotFoundException;
    public void showFromParyalUser() throws ClassNotFoundException, SQLException, FileNotFoundException;
}
