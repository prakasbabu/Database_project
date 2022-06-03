package com.example.database_project_final;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao implements ILoginTable{


    private Connection connection;

    public LoginDao() throws SQLException, FileNotFoundException, ClassNotFoundException {
        DbConnection newConnection = new DbConnection();
        connection = newConnection.getConnection();
    }



    @Override
    public void insertInParyalLogin(Login l) throws ClassNotFoundException, SQLException, FileNotFoundException {
        String sql = " insert into paryallogin (loginId,username, password, userId) values (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,l.getLoginId());
        ps.setString(2, l.getUsername());
        ps.setString(3, l.getPassword());
        ps.setInt(4, l.getUserId());
        System.out.println(ps);
        ps.execute();
        ps.close();

    }

    @Override
    public void updateInParyalLogin(Login l) throws ClassNotFoundException, SQLException, FileNotFoundException {
        String sql = " update paryallogin set username=?,password=?, userId =? where loginId=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, l.getUsername());
        ps.setString(2, l.getPassword());
        ps.setInt(3, l.getUserId());
        ps.setInt(4, l.getLoginId());
        ps.execute();
        ps.close();

    }

    @Override
    public void deleteInParyalLogin(Login l) throws ClassNotFoundException, SQLException, FileNotFoundException {

        String sql = "Delete from paryallogin where loginId =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, l.getLoginId());
        ps.execute();
        ps.close();

    }

    @Override
    public Login searchInParyalLogin(Login l) throws ClassNotFoundException, SQLException, FileNotFoundException {
        String sql = "select loginId,username,password, userId from paryallogin where loginId =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, l.getLoginId());

        int counter =0;
        ResultSet rs = ps.executeQuery();

        if (rs.next()){

            l.setUsername(rs.getString("username"));
            l.setPassword(rs.getString("password"));
            l.setUserId(rs.getInt("userId"));
            counter++;

          System.out.println("did it get till here");
        }


        if ( counter == 0){
            l = new Login();
        }
        rs.close();
        ps.close();
        return l;




       /* StringBuffer  sql = new StringBuffer();
        sql.append("select l.loginId AS loginID Login, l.username AS Login Name, l.password As Password");
        sql.append("a.userId AS UserID User,a.firstName AS First Name,a.lastName AS Last Name, a.emailAddress as Email Address");
        sql.append("a.accessLevel AS Access");
        sql.append(" From paryallogin l inner join paryaluser a");
        sql.append(" on l.userId = a.userId");
        sql.append("where l.userId =? ");
        PreparedStatement ps = connection.prepareStatement(sql.toString());
        ps.setInt(1, l.getLoginId());
        ResultSet rs = ps.executeQuery();
        int counter =0;

        if (rs.next()){


            User a = new User();
            a.setUserId(rs.getInt("userId"));
            a.setFirstName(rs.getString("firstName"));
            a.setLastName(rs.getString("lastName"));
            a.setEmailAddress(rs.getString("emailAddress"));
            a.setAccessLevel(rs.getString("accessLevel"));

            l.setUsername(rs.getString("username"));
            l.setPassword(rs.getString("password"));
            l.setUser(a);
            counter++;

        }

        if (counter ==0){

            l= new Login();
            User a = new User();
            l.setUser(a);


        }
        rs.close();
        ps.close();
        return l;*/
    }

    @Override
    public List<Login> showParyalLogin() throws  SQLException {

       String sql = "select loginId, username, password,userId from paryallogin";
        PreparedStatement ps = connection.prepareStatement(sql);
        int counter =0;
        ResultSet rs = ps.executeQuery();
        List <Login> loginlist = new ArrayList<>();
        while ( rs.next()){
            Login alluser = new Login();
            alluser.setLoginId(rs.getInt("loginId"));
            alluser.setUsername(rs.getString("username"));
            alluser.setPassword(rs.getString("password"));
            alluser.setUserId(rs.getInt("userId"));
            loginlist.add(alluser);

        }
        rs.close();
        ps.close();

        return loginlist;
    }



    }
       /* List <Login> listlogin = new ArrayList<Login>();
        StringBuffer  sql = new StringBuffer();
        sql.append("select l.loginId AS loginID Login, l.username AS Login Name, l.password As Password");
        sql.append("a.userId AS UserID User,a.firstName AS First Name,a.lastName AS Last Name, a.emailAddress as Email Address");
        sql.append("a.accessLevel AS Access");
        sql.append(" From paryallogin l inner join paryaluser a");
        sql.append(" on l.userId = a.userId");
        PreparedStatement ps = connection.prepareStatement(sql.toString());
        int counter =0;
        ResultSet rs = ps.executeQuery();

        while ( rs.next()){
            User alluser = new User();
            alluser.setUserId(rs.getInt("userId"));
            alluser.setFirstName(rs.getString("firstName"));
            alluser.setLastName(rs.getString("lastName"));
            alluser.setEmailAddress(rs.getString("emailAddress"));
            alluser.setAccessLevel(rs.getString("accessLevel"));

            Login l = new Login();
            l.setUsername(rs.getString("username"));
            l.setPassword(rs.getString("password"));
            l.setUser(alluser);


            listlogin.add(l);

        }
        rs.close();
        ps.close();

        return listlogin;
    }
*/


