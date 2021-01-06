package utils;

import Model.Login;
import Model.Manage;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class HandleManageModifyPassword extends ConnectDatabase {

    public int handModifyPassword(Manage login){
        connectDatabase();
        PreparedStatement preSql;
        int rs = 0;
        if(con==null){
            login.setStatus(false);
            return 0;
        }
        long id =login.getId();
        String pw=login.getPassword();
        String strSQL = "update manage_table set password = ? where id = ?";

        try {
            preSql = con.prepareStatement(strSQL);
            preSql.setString(1,pw);
            preSql.setLong(2,id);
            rs = preSql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
