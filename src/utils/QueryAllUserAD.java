package utils;

import Model.Advertisement;
import Model.Login;
import Model.Register;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//查询广告
public class QueryAllUserAD extends ConnectDatabase {
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Advertisement[] queryAllUser(){
        //获取链接
        connectDatabase();
        if (con==null || login==null)
            return null;
        if (login.getLoginSuccess()==false)
            return null;

        Advertisement [] ad=null;
        Statement sql;
        ResultSet rs;
        try {
            // TYPE_SCROLL_INSENSITIVE  双向滚动，但不及时更新，就是如果数据库里的数据修改过，并不在ResultSet中反应出来。   CONCUR_READ_ONLY  只可向前滚动
            sql=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=sql.executeQuery("select * from guanggao_table");
            // 将光标移到最后
            rs.last();

            int recordAmount=rs.getRow();
            ad=new Advertisement[recordAmount];
            for (int i = 0; i < ad.length; i++) {
                ad[i]=new Advertisement();
            }
            //移动到第一个之前
            rs.beforeFirst();
            int i=0;
            while (rs.next()){
                String id=rs.getString(1);
                ad[i].setID(id);
                ad[i].setContent(rs.getString(2));
                InputStream in=rs.getBinaryStream(3);
                int length=in.available();
                byte [] b=new byte[length];
                in.read(b);
                in.close();
                Image img =Toolkit.getDefaultToolkit().createImage(b);
                ad[i].setImage(img);
                String number=rs.getString(4);
                int index=id.length();
                number=number.substring(index);
                ad[i].setSerialNumber(number);
                i++;
            }
            con.close();
        } catch (Exception e) {

        }
        return ad;
    }
}

















