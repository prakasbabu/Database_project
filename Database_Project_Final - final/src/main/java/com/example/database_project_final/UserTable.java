package com.example.database_project_final;

import java.sql.SQLException;
import java.util.List;

public interface UserTable {
    public  void insertInParyalUser(User a) throws SQLException;

    public void updateInParyalUser(User a) throws SQLException ;

    public void deleteInParyalUser(User a) throws SQLException;

    public User searchInParyalUser(User a) throws SQLException ;
    public List<User> showParyalUsers() throws  SQLException;
}
