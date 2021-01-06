package test;

import Model.Login;
import utils.DelAdvertisement;
import utils.HandleLogin;

public class DeleteAdTest {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("aa11");
        login.setPassword("aa11");
        HandleLogin handleLogin = new HandleLogin();
        handleLogin.handleLogin(login);

        DelAdvertisement delAdvertisement = new DelAdvertisement();
        delAdvertisement.setLogin(login);

        boolean b = delAdvertisement.delAdvertisement("006");
        if (b){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }


    }
}
