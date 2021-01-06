package view;
import Model.Login;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * 浏览某个用户广告
 */
public class QueryOneUserADView extends JPanel {
   public Login login;
   public JTextField inputID;   
   JButton submit;             
   public AdvertisingBoardView  pCenter ;       
   HandleQueryOneUserAD  handleQueryOneUserAD;
   QueryOneUserADView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      //边框布局
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      pCenter = new AdvertisingBoardView();
      inputID = new JTextField(12);
      submit = new JButton("提交");
      pNorth.add(new JLabel("输入某个用户ID，查询ID做的广告"));
      pNorth.add(inputID);
      pNorth.add(submit);
      add(pNorth,BorderLayout.NORTH);
      add(pCenter,BorderLayout.CENTER);
   }
   private void registerListener() {
      handleQueryOneUserAD = new HandleQueryOneUserAD();
      handleQueryOneUserAD.setView(this);
      submit.addActionListener(handleQueryOneUserAD);
   }
}