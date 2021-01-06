package view;
import Model.Advertisement;
import Model.AdvertisingBoard;
import utils.QueryAllUserAD;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class HandleQueryAllUserAD implements ActionListener {
   QueryAllUserAD queryAll;
   QueryAllUserADView view ;
   public HandleQueryAllUserAD(){
      queryAll = new QueryAllUserAD();
   }
   public void actionPerformed(ActionEvent e) {
      //判断登录状态
      queryAll.setLogin(view.login);
      if(view.login.getLoginSuccess() == false){
        JOptionPane.showMessageDialog
        (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      // 查询的 广告结果数组
      Advertisement[] ad = queryAll.queryAllUser();
      if(ad == null ) return;
      AdvertisingBoard board = new AdvertisingBoard();
      board.setAdvertisement(ad);


      view.pCenter.setAdvertisingBoard(board);        
      view.pCenter.next.doClick();
   }
   public void setView(QueryAllUserADView view) {
      this.view = view;
   }
}