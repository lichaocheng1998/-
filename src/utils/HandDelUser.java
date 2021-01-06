package utils;

import Model.Manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class HandDelUser extends ConnectDatabase{
    Manage manage;

    public void setManage(Manage manage) {
        this.manage = manage;
    }

    public boolean delUser(String id){
        boolean success = false;
        connectDatabase();
        PreparedStatement preSql;
        if (con==null || manage==null)
            return false;
        if (manage.isStatus()==false)
            return false;
        connectDatabase();
        String strSQL = "delete from register_table where id = ?";
        delAdv(con,id);
        try {
            preSql=con.prepareStatement(strSQL);
            preSql.setString(1,id);
            int isOK=preSql.executeUpdate();
            if (isOK !=0)
                success=true;
            else
                success=false;
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            success=false;
        }
        return success;

    }

    private boolean delAdv(Connection con,String id) {
        boolean success = false;
        PreparedStatement preSql;
        String strSQL = "delete from guanggao_table where id = ?";
        try {
            preSql=con.prepareStatement(strSQL);
            preSql.setString(1,id);
            int isOK=preSql.executeUpdate();
            if (isOK !=0)
                success=true;
            else success=false;
//            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            success=false;
        }
        return success;
    }
}
