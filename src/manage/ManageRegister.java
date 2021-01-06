package manage;

import Model.Manage;
import utils.ConnectDatabase;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageRegister extends ConnectDatabase {
    public boolean register(Manage manage) {
        connectDatabase();
        boolean isSuccess = false;
        if (con == null)
            return false;
        PreparedStatement preSql;
        String sqlStr = "insert into manage_table values(null,?,?)";
        int ok = 0;
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, manage.getUsername());
            String pw = manage.getPassword();
            //  pw = Encrypt.encrypt(pw, "mimajiami");
            preSql.setString(2, pw);
            ok = preSql.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (ok != 0) {
            isSuccess = true;
        }
        return isSuccess;
    }
}
