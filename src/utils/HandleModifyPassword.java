package utils;

import Model.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*修改登陆密码*/
public class HandleModifyPassword extends ConnectDatabase {

    public int handModifyPassword(Login login){
        connectDatabase();
        PreparedStatement preSql;
        int rs = 0;
        if(con==null){
            login.setLoginSuccess(false);
            return 0;
        }
        String id=login.getId();
        String pw=login.getPassword();
        String strSQL = "update register_table set password = ? where id = ?";

        try {
            preSql = con.prepareStatement(strSQL);
            preSql.setString(1,pw);
            preSql.setString(2,id);
            rs = preSql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
