package utils;

import Model.Login;
import Model.Manage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
//删除广告
public class DelAdvertisement extends ConnectDatabase {
    Login login;
    Manage manageLogin;
    public void setLogin(Login login) {
        this.login = login;
    }
    public void setLogin(Manage login) {
        this.manageLogin = login;
    }
    public boolean delAdvertisement (String serialNumber){
        boolean success=false;
        connectDatabase();
        PreparedStatement preSql;
        if (manageLogin == null){
            if (con==null || login==null)
                return false;
            if (login.getLoginSuccess()==false)
                return false;
        }
        connectDatabase();
        String SQL ="delete from guanggao_table where serialNumber=?";
        try {
            preSql=con.prepareStatement(SQL);
            preSql.setString(1,serialNumber);
            int isOK=preSql.executeUpdate();
            if (isOK !=0)
                success=true;
            else success=false;
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            success=false;
        }
        return success;
    }
}



