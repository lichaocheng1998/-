package view;
import Model.Register;
import utils.HandleRegister;

import javax.swing.*;
import java.awt.event.*;

public class RegisterView extends JPanel implements ActionListener {
   Register register;
   JTextField inputID;           
   JPasswordField inputPassword;
   JPasswordField againPassword;
   JButton buttonRegister;
   RegisterView() {
      // 将组件添加进jframe
      register = new Register();
      inputID = new JTextField(12);
      inputPassword = new JPasswordField(12);
      againPassword = new JPasswordField(12);
      buttonRegister = new JButton("注册");
      add(new JLabel("输入ID:"));
      add(inputID);
      add(new JLabel("设置密码"));
      add(inputPassword);
      add(new JLabel("再次输入密码:"));
      add(againPassword);
      add(buttonRegister);
      //当点击触发事件
      buttonRegister.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e) {
      //获取到输入的所有信息
      String id = inputID.getText().trim();
      char [] pw =inputPassword.getPassword();
      char [] pw_again =againPassword.getPassword();
      String pwStr = new String(pw).trim();
      if(id.length() == 0 ||pwStr.length()==0 ){
         JOptionPane.showMessageDialog
         (null,"注册失败","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String pw_againStr = new String(pw_again).trim();
      //判断再次输入的密码与密码是否一致
      if(pwStr.equals(pw_againStr)){
        register.setId(id);
        register.setPassword(new String(pw));

        HandleRegister handleRegister = new HandleRegister();
        boolean boo =handleRegister.handleRegister(register);
        if(boo) 
           JOptionPane.showMessageDialog
         (null,"注册成功","注册对话成功框", JOptionPane.WARNING_MESSAGE);
        else
           JOptionPane.showMessageDialog
         (null,"注册失败，换个ID","消息对话框", JOptionPane.WARNING_MESSAGE);
      }
      else {
         JOptionPane.showMessageDialog
         (null,"两次输入密码不同","消息对话框", JOptionPane.WARNING_MESSAGE);
      } 
   }
}
