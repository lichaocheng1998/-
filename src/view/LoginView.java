package view;
import Model.Login;
import utils.HandleLogin;

import javax.swing.*;
import java.awt.event.*;

public class LoginView extends JPanel implements ActionListener {
   Login login;
   JTextField inputID;
   JPasswordField inputPassword;
   JButton buttonLogin; 
   JButton buttonExit;  
   public void setLogin(Login login){
      this.login = login;
   }
   LoginView() {
      inputID = new JTextField(12);
      inputPassword = new JPasswordField(12);
      buttonLogin = new JButton("登录");
      buttonExit = new JButton("退出登录");
      add(new JLabel("ID:"));
      add(inputID);
      add(new JLabel("密码:"));
      add(inputPassword);
      add(buttonLogin);
      add(buttonExit);
      buttonExit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            login.setLoginSuccess(false);
         }});//匿名内部类
      buttonLogin.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e) {
      login.setId(inputID.getText());
      char [] pw =inputPassword.getPassword();
      login.setPassword(new String(pw));
      HandleLogin handleLogin = new HandleLogin();
      login = handleLogin.handleLogin(login);
      if(login.getLoginSuccess() == true) {
        JOptionPane.showMessageDialog
         (null,"登录成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
      }
      else {
        JOptionPane.showMessageDialog
         (null,"登录失败","消息对话成功框", JOptionPane.WARNING_MESSAGE);
      }
  }
}
