package manage;
import Model.Login;
import Model.Manage;
import utils.DelAdvertisement;
import view.HandleDelAdvertisement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelAdvertisementView extends JPanel {
   Manage login;
   JTextField inputSerialNumber;  
   JButton submit;              
   JTextField hintMess;

   DelAdvertisement delAdvertisement;
   DelAdvertisementView() {
      delAdvertisement = new DelAdvertisement();
      initView();
   }
   public void setLogin(Manage login){
      this.login = login;
   }
   private void initView() {
      // 设置组件
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      inputSerialNumber = new JTextField(20);
      submit = new JButton("删除广告");
      submit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            delAdv();
         }
      });
      add(new JLabel("输入用户id+广告的序列号："));
      add(inputSerialNumber);
      add(submit);
      add(hintMess);
   }

   private void delAdv() {
      //获取登录状态判断是否登录
      if(login.isStatus() == false){
         JOptionPane.showMessageDialog
                 (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      String number = inputSerialNumber.getText().trim();
      delAdvertisement.setLogin(login);
      boolean boo = delAdvertisement.delAdvertisement(number);
      if(boo)
         hintMess.setText("删除成功");
      else
         hintMess.setText("删除失败，没有该广告");
   }
}