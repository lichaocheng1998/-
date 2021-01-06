package utils;

import Model.Advertisement;
import Model.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//添加广告
public class AddAdvertisement extends ConnectDatabase {
    Login login;


    public void  setLogin(Login login) {
        this.login = login;
    }
    public boolean addAdvertisement (Advertisement ad){
        //获取链接
        connectDatabase();
        if(con==null || login==null)
            return false;
        if(login.getLoginSuccess()==false)
            return false;

        boolean success=false;
        PreparedStatement preSql;
        String sqlStr="insert into guanggao_table values(?,?,?,?)";
        try {
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1,login.getId());
            String content=ad.getContent();
            preSql.setString(2,content);
            // 创建文件对象与文件输入流
            File f=ad.getPictureFile();
            InputStream in=new FileInputStream(f);
            int length=in.available();
            preSql.setBinaryStream(3,in,length);
            preSql.setString(4,login.getId()+ad.getSerialNumber());
            int isOK=preSql.executeUpdate();

            if (isOK !=0)
                success=true;
            else
                success=false;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            success=false;
        }
        return success;
    }
}















