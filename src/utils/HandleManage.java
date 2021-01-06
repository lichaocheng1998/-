package utils;

import Model.Manage;
import utils.ConnectDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HandleManage extends ConnectDatabase {

    public Manage handLeLogin(Manage manage){
        connectDatabase();
        PreparedStatement preSql;
        ResultSet rs;
        if(con==null){
            manage.setStatus(false);
            return manage;
        }
        String username = manage.getUsername();
        String password = manage.getPassword();

        String strSQL = "select * from manage_table where username = ? and password = ?";
        try {
            preSql=con.prepareStatement(strSQL);
            preSql.setString(1,username);
            preSql.setString(2,password);
            rs=preSql.executeQuery();


            if (rs.next()==true){
                manage.setId(rs.getLong("id"));
                manage.setStatus(true);
            }
            else {
                manage.setStatus(false);
            }
        } catch (SQLException e) {
            manage.setStatus(false);
            e.printStackTrace();
        }
        return manage;
    }
}
