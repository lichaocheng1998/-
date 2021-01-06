package utils;



import Model.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*public boolean update(Login login,String pw){
1.连接数据库
2.定义sql语句
3.设置sql语句的值
4.执行sql语句
5.对sql语句的返回值作判断
string sql="update register_table set password=? where id=?"*/

public class UpdateUserpw extends ConnectDatabase {
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean updatepw(String pw){
        connectDatabase();
        PreparedStatement preSql;
        String id=login.getId();
        boolean su=false;

        String sqlStr="update register_table set password=? where id=?";
        try {
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1,pw);
            preSql.setString(2,id);
            int i = preSql.executeUpdate();
            if (i !=0){
                su=true;
            }else {
                su=false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return su;
    }


}
