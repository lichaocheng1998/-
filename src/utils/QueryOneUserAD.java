package utils;

import Model.Advertisement;
import Model.Login;

import java.awt.*;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryOneUserAD extends ConnectDatabase {
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }
    public Advertisement[] queryOneUser(String id){
        //获取连接
        connectDatabase();
        if(con==null || login==null)
            return null;
        if(login.getLoginSuccess()==false)
            return null;

        Advertisement [] ad=null;
        Statement sql;
        ResultSet rs;
        try {
            //根据 id 查询广告
            sql=con.createStatement
            (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String strSql = "select * from guanggao_table where id ='"+id+"'";
            rs=sql.executeQuery(strSql);
            rs.last();
            int recordAmount=rs.getRow();
            ad=new Advertisement[recordAmount];
            for (int i=0;i<ad.length;i++){
                ad[i]=new Advertisement();
            }
            //移动光标
            rs.beforeFirst();
            int i=0;
            while (rs.next()){
                ad[i].setID(id);
                ad[i].setContent(rs.getString("content"));
                InputStream in=rs.getBinaryStream("imageFile");
                int length=in.available();
                byte [] b=new byte[length];
                in.read(b);
                in.close();
                //拿到图片对象
                Image img=Toolkit.getDefaultToolkit().createImage(b);
                ad[i].setImage(img);
                String number=rs.getString("serialNumber");
                int index=id.length();
                number=number.substring(index);
                ad[i].setSerialNumber(number);
                i++;


            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ad;
    }
}













