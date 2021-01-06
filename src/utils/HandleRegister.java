package utils;

import Model.Encrypt;
import Model.Register;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HandleRegister extends ConnectDatabase {
    public boolean handleRegister(Register redister) {
        connectDatabase();
        boolean isSuccess = false;
        if (con == null)
            return false;
        PreparedStatement preSql;
        String sqlStr = "insert into register_table values(?,?)";
        int ok = 0;
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, redister.getId());
            String pw = redister.getPassword();
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

