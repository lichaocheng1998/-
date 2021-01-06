package manage;

import Model.Manage;
import utils.HandDelUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DelUserView extends JPanel {
    //*JPanel
    Manage login;
    JTextField inputID;
    JButton del;

    public void setLogin(Manage login) {
        this.login = login;
    }

    DelUserView(){
        inputID = new JTextField(12);

        del = new JButton("删除");

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delUser();
            }
        });
        add(new JLabel("用户ID:"));
        add(inputID);
        add(del);
    }

    private void delUser() {
        String id = inputID.getText();
        HandDelUser handDelUser = new HandDelUser();
        handDelUser.setManage(login);
        boolean b = handDelUser.delUser(id);
        if (b){

            JOptionPane.showMessageDialog
                    (null,"删除成功","消息对话框", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog
                    (null,"删除失败","消息对话框", JOptionPane.WARNING_MESSAGE);
        }

    }
}
