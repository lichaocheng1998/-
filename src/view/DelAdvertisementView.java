package view;
import Model.Login;

import javax.swing.*;
import java.awt.*;
public class DelAdvertisementView extends JPanel {
   Login login;
   JTextField inputSerialNumber;  
   JButton submit;              
   JTextField hintMess; 
   HandleDelAdvertisement handleDelAdvertisement;
   DelAdvertisementView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      // 设置组件
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      inputSerialNumber = new JTextField(20);
      submit = new JButton("删除广告");
      add(new JLabel("输入用户id+广告的序列号："));
      add(inputSerialNumber);
      add(submit);
      add(hintMess);
   }
   private void registerListener() {
      //传递视图并给提交按钮注册监听
      handleDelAdvertisement = new HandleDelAdvertisement();
      handleDelAdvertisement.setView(this);
      submit.addActionListener(handleDelAdvertisement);
   }
}