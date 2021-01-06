package test;

import Model.Login;
import utils.HandleLogin;
import utils.UpdateUserpw;

public class UpdateTest {
    public static void main(String[] args) {

        //1.登录

        //2.调用修改方法

        //3.对修改方法的返回值进行判断
        Login login = new Login();
        login.setId("aa11");
        login.setPassword("2222");
        HandleLogin handleLogin = new HandleLogin();
        handleLogin.handleLogin(login);

        UpdateUserpw updateUserpw = new UpdateUserpw();
        updateUserpw.setLogin(login);

        boolean aa11 = updateUserpw.updatepw("aa11");

        if (aa11){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

    }
}
