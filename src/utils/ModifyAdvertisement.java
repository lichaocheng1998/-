package utils;

import Model.Advertisement;
import Model.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;

/**
 * 修改广告
 */
public class ModifyAdvertisement extends ConnectDatabase {
    Login login;

    public void  setLogin(Login login) {
        this.login = login;
    }

    public int modifyAdvertisement(Advertisement ad){
        //获取链接
        connectDatabase();
        int i = 0;
        if(con==null || login==null)
            return 0;
        if(login.getLoginSuccess()==false)
            return 0;

        PreparedStatement preSql;
        String strSQL = "";

        try {
            if (ad.getPictureFile() == null){
                strSQL = "update guanggao_table set content = ? where serialNumber = ? and id=?";
                preSql=con.prepareStatement(strSQL);
                preSql.setString(1,ad.getContent());
                preSql.setString(2,ad.getSerialNumber());
                preSql.setString(3,login.getId());
            }else{
                strSQL = "update guanggao_table set content = ?,imageFile = ? where serialNumber = ? and id=?";
                preSql=con.prepareStatement(strSQL);
                preSql.setString(1,ad.getContent());
                // 创建文件对象与文件输入流
                File f=ad.getPictureFile();
                InputStream in=new FileInputStream(f);
                // 返回数据的长度大小
                int length=in.available();
                preSql.setBinaryStream(2,in,length);
                preSql.setString(3,ad.getSerialNumber());
                preSql.setString(4,login.getId());
            }
            // 执行语句拿到返回
            i=preSql.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
