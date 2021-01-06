package view;

/**
 * @Author licc on 2020/12/25 9:18
 */

import Model.Login;
import utils.HandleModifyPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 密码修改
 */
public class ModifyPassword extends JPanel implements ActionListener {

    Login login;
    JTextField inputID;
    JPasswordField oldInputPassword;
    JPasswordField newInputPassword;

    JButton modify;

    public void setLogin(Login login) {
        this.login = login;
    }

    ModifyPassword(){
        inputID = new JTextField(12);
        oldInputPassword = new JPasswordField(12);
        newInputPassword = new JPasswordField(12);
        modify = new JButton("修改");

        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("旧密码:"));
        add(oldInputPassword);
        add(new JLabel("新密码:"));
        add(newInputPassword);
        add(modify);
        modify.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = inputID.getText();
        String oldPassword = new String(oldInputPassword.getPassword());
        String newPassword = new String(newInputPassword.getPassword());
        //判断要改的密码是否为当前登录用户
        if (!name.equals(login.getId())){
            JOptionPane.showMessageDialog
                    (null,"修改失败，修改账号不是当前登录账号","消息对话成功框", JOptionPane.WARNING_MESSAGE);
        }else if (!oldPassword.equals(login.getPassword())){
            JOptionPane.showMessageDialog
                    (null,"修改失败，旧密码不正确","消息对话成功框", JOptionPane.WARNING_MESSAGE);
        }else{
            login.setPassword(newPassword);
            HandleModifyPassword handleModifyPassword = new HandleModifyPassword();
            int i = handleModifyPassword.handModifyPassword(login);
            if (i == 0){
                JOptionPane.showMessageDialog
                        (null,"修改失败","消息对话成功框", JOptionPane.WARNING_MESSAGE);
            }else{
                login.setLoginSuccess(false);
                JOptionPane.showMessageDialog
                        (null,"修改成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
            }

        }

    }
}
