package manage;

import Model.Manage;
import utils.HandleManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManageLoginView extends JPanel {
    Manage manage;
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonLogin;
    JButton buttonExit;

    public void setManage(Manage manage) {
        this.manage = manage;
    }

    ManageLoginView(){
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        buttonLogin = new JButton("登录");
        buttonExit = new JButton("退出登录");
        // 将组件添加进 jframe
        add(new JLabel("账户:"));
        add(inputID);
        add(new JLabel("密码:"));
        add(inputPassword);
        add(buttonLogin);
        add(buttonExit);

        // 给退出登录注册事件
        buttonExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                manage.setStatus(false);
            }});
        // 给登录按钮注册事件，当事件被触发的时候会执行 actionPerformed
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manage.setUsername(inputID.getText());
                char [] pw =inputPassword.getPassword();
                manage.setPassword(new String(pw));
                HandleManage handleManage = new HandleManage();
                manage = handleManage.handLeLogin(manage);
                if(manage.isStatus() == true) {
                    JOptionPane.showMessageDialog
                            (null,"登录成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog
                            (null,"登录失败","消息对话成功框", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
