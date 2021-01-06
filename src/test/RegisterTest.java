package test;

import Model.Register;
import utils.HandleRegister;

public class RegisterTest {
    public static void main(String[] args) {
        Register register = new Register();
        register.setId("aa11");
        register.setPassword("aa11");

        HandleRegister handleRegister = new HandleRegister();
        boolean b = handleRegister.handleRegister(register);
        if (b){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }


    }
}
