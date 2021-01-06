package test;

import Model.Advertisement;
import Model.Login;
import utils.HandleLogin;
import utils.QueryAllUserAD;

public class queryOneTest {
    public static void main(String[] args) {

        Login login = new Login();
        login.setId("123");
        login.setPassword("456");
        HandleLogin handleLogin = new HandleLogin();
        login= handleLogin.handleLogin(login);

//        QueryOneUserAD queryOneUerAD = new QueryOneUserAD();
//        queryOneUerAD.setLogin(login);
//
//        Advertisement[] advertisements = queryOneUerAD.queryOneUerAD("123");
// 
//        for (int i = 0; i < advertisements.length; i++) {
//            System.out.println(advertisements[i].toString());
//        }

        QueryAllUserAD queryAllUserAD = new QueryAllUserAD();
        queryAllUserAD.setLogin(login);

        Advertisement[] advertisement = queryAllUserAD.queryAllUser();
        for (int i = 0; i < advertisement.length; i++) {
            System.out.println(advertisement[i].toString());
        }

    }

}
