package test;

import Model.Login;
import utils.HandleLogin;

public class LoginTest {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("aa11");
        login.setPassword("123456");

        HandleLogin handleLogin = new HandleLogin();
        Login login1 = handleLogin.handleLogin(login);

        if (login1.getLoginSuccess()==true) {

            System.out.println("登陆成功");
        }
        else {
            System.out.println("登陆失败");
        }
    }
}
