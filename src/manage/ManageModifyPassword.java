package manage;

/**
 * @Author licc on 2020/12/25 9:18
 */

import Model.Login;
import Model.Manage;
import utils.HandleManageModifyPassword;
import utils.HandleModifyPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 密码修改
 */
public class ManageModifyPassword extends JPanel{

    Manage login;
    JTextField inputID;
    JPasswordField newInputPassword;

    JButton modify;

    public void setLogin(Manage login) {
        this.login = login;
    }

    ManageModifyPassword(){
        inputID = new JTextField(12);
        newInputPassword = new JPasswordField(12);
        modify = new JButton("修改");
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = inputID.getText();
                String newPassword = new String(newInputPassword.getPassword());
                if (!name.equals(login.getUsername())){
                    JOptionPane.showMessageDialog
                            (null,"修改失败，修改账号不是当前登录账号","消息对话成功框", JOptionPane.WARNING_MESSAGE);
                }else{
                    login.setId(login.getId());
                    login.setPassword(newPassword);
                    HandleManageModifyPassword handleModifyPassword = new HandleManageModifyPassword();
                    int i = handleModifyPassword.handModifyPassword(login);
                    if (i == 0){
                        JOptionPane.showMessageDialog
                                (null,"修改失败","消息对话成功框", JOptionPane.WARNING_MESSAGE);
                    }else{
                        login.setStatus(false);
                        JOptionPane.showMessageDialog
                                (null,"修改成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("新密码:"));
        add(newInputPassword);
        add(modify);
    }

}
