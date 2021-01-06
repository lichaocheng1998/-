package test;

import Model.Advertisement;
import Model.Login;
import utils.AddAdvertisement;
import utils.HandleLogin;

import java.io.File;

public class AddAdTest {
    public static void main(String[] args) {
        Login login = new Login();
        login.setId("aa11");
        login.setPassword("aa11");
        HandleLogin handleLogin = new HandleLogin();
        login=handleLogin.handleLogin(login);



        AddAdvertisement addAdvertisement = new AddAdvertisement();
        addAdvertisement.setLogin(login);

        Advertisement advertisement = new Advertisement();
        advertisement.setID(login.getId());
        advertisement.setContent("123456789");
        File file = new File("src/1.jpg");
        advertisement.setPictureFile(file);
        advertisement.setSerialNumber("006");


        boolean b = addAdvertisement.addAdvertisement(advertisement);
        if (b) {

            System.out.println("添加成功");
        }else{

            System.out.println("添加失败");
        }


    }
}
