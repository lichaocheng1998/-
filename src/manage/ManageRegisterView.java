package manage;


import Model.Manage;
import Model.Register;
import utils.HandleRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageRegisterView extends JPanel implements ActionListener {
    Manage manage;
    JTextField inputUserName;
    JPasswordField inputPassword;
    JPasswordField againPassword;
    JButton buttonRegister;
    ManageRegisterView() {
        // 将组件添加进jframe
        manage = new Manage();
        inputUserName = new JTextField(12);
        inputPassword = new JPasswordField(12);
        againPassword = new JPasswordField(12);
        buttonRegister = new JButton("注册");
        add(new JLabel("输入账户:"));
        add(inputUserName);
        add(new JLabel("设置密码"));
        add(inputPassword);
        add(new JLabel("再次输入密码:"));
        add(againPassword);
        add(buttonRegister);
        //当点击触发事件
        buttonRegister.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {

        String username = inputUserName.getText().trim();//.trim()去空格
        char [] pw =inputPassword.getPassword();
        char [] pw_again =againPassword.getPassword();
        String pwStr = new String(pw).trim();
        if(username.length() == 0 ||pwStr.length()==0 ){
            JOptionPane.showMessageDialog
                    (null,"注册失败","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String pw_againStr = new String(pw_again).trim();
        //判断再次输入的密码与密码是否一致
        if(pwStr.equals(pw_againStr)){
//            register.setId(id);
//            register.setPassword(new String(pw));
            manage.setUsername(username);
            manage.setPassword(new String(pw));
            ManageRegister manageRegiter = new ManageRegister();
            boolean boo=manageRegiter.register(manage);
//            HandleRegister handleRegister = new HandleRegister();
//            boolean boo =handleRegister.handleRegister(register);
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
// `id` bigint(20) NOT NULL AUTO_INCREMENT,
