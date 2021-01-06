package view;
import Model.Login;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * 浏览全部广告
 */
public class QueryAllUserADView extends JPanel {
   public Login login;
   JButton submit;                             
   public AdvertisingBoardView  pCenter ;      
   HandleQueryAllUserAD  handleQueryAllUserAD;  
   QueryAllUserADView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      //设置边框布局
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel(); 
      pCenter = new AdvertisingBoardView();
      submit = new JButton("浏览全部广告");
      pNorth.add(submit);
      //南布局
      add(pNorth,BorderLayout.NORTH);

      add(pCenter,BorderLayout.CENTER);
   }
   private void registerListener() {
      handleQueryAllUserAD = new HandleQueryAllUserAD();
      handleQueryAllUserAD.setView(this);
      submit.addActionListener(handleQueryAllUserAD);
   }
}