package utils;

import Model.Login;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/*update guanggao_table set content=?where id=?*/
public class UpdateContent extends ConnectDatabase {
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }
    public boolean updatecon(String con){
        connectDatabase();
        PreparedStatement preSql;
        String id=login.getId();
        String pw=login.getPassword();
        boolean su=false;
        String sqlStr="update guanggao_table set content=? where id=?";


        return su;
    }

}
