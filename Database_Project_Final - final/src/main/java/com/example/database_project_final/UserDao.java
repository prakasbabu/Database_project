package com.example.database_project_final;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserTable {

    private Connection connection;

    public UserDao() throws SQLException, FileNotFoundException, ClassNotFoundException {
        DbConnection newConnection = new DbConnection();
        connection = newConnection.getConnection();
    }


    @Override
    public void insertInParyalUser(User a) throws SQLException {
        String sql = " insert into paryaluser(userId, firstName, lastName,emailAddress, accessLevel) values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, a.getUserId());
        ps.setString(2, a.getFirstName());
        ps.setString(3, a.getLastName());
        ps.setString(4, a.getEmailAddress());
        ps.setString(5, a.getAccessLevel());
        System.out.println(ps);
        ps.execute();
        ps.close();


    }

    @Override
    public void updateInParyalUser(User a) throws SQLException {
        String sql = " update paryaluser set firstName = ?,lastName =?,emailAddress =?,accessLevel =? where userId =?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getFirstName());
        ps.setString(2, a.getLastName());
        ps.setString(3, a.getEmailAddress());
        ps.setString(4, a.getAccessLevel());
        ps.setInt(5, a.getUserId());
        ps.execute();
        ps.close();

    }

    @Override
    public void deleteInParyalUser(User a) throws SQLException {
        String sql = " delete from ParyalUser where userId = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, a.getUserId());
        ps.execute();
        ps.close();
    }

    @Override
    public User searchInParyalUser(User a) throws SQLException {
        String sql = "select userId,firstName,lastName,emailAddress,accessLevel from paryaluser where userId =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, a.getUserId());

       int counter =0;
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            a.setFirstName((rs.getString("firstName")));
            a.setLastName((rs.getString("lastName")));
            a.setEmailAddress((rs.getString("emailAddress")));
            a.setAccessLevel(rs.getString("accessLevel"));
           counter ++;
            System.out.println("did it get till here");
        }


        if ( counter == 0){
            a = new User();
        }
        rs.close();
        ps.close();
        return a;
    }

    @Override
    public List<User> showParyalUsers() throws SQLException {
        String sql = "select userId,firstName,lastName,emailAddress,accessLevel from paryaluser";
        PreparedStatement ps = connection.prepareStatement(sql);
        int counter =0;
        ResultSet rs = ps.executeQuery();
        List <User> users = new ArrayList<User>();
        while ( rs.next()){
            User alluser = new User();
            alluser.setUserId(rs.getInt("userId"));
            alluser.setFirstName(rs.getString("firstName"));
            alluser.setLastName(rs.getString("lastName"));
            alluser.setEmailAddress(rs.getString("emailAddress"));
            alluser.setAccessLevel(rs.getString("accessLevel"));
            users.add(alluser);

        }
        rs.close();
        ps.close();

        return users;
    }

}
