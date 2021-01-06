package view;
import Model.Advertisement;
import utils.AddAdvertisement;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class HandleAddAdvertisement implements ActionListener {
   AddAdvertisementView view ;
   AdvertisingBoardView advertisingBoardView;
   AddAdvertisement addAdvertisement;
   Advertisement ad;
   public HandleAddAdvertisement(){
      addAdvertisement = new AddAdvertisement();
      ad = new Advertisement();
   }

   public void actionPerformed(ActionEvent e) {
      if (view != null){
         isAddAdvertisementView(e);
      }
   }
   public void setView(AddAdvertisementView view) {
      this.view = view;
   }

   public void setView(AdvertisingBoardView view) {
      this.advertisingBoardView = view;
   }

   public void isAddAdvertisementView(ActionEvent e){
      addAdvertisement.setLogin(view.login);
      if(view.login.getLoginSuccess() == false){
         JOptionPane.showMessageDialog
                 (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
         return;
      }
      if(e.getSource()==view.inputPictureFile) {
         JFileChooser fileDialog=new JFileChooser();
         int state=fileDialog.showOpenDialog(null);
         if(state==JFileChooser.APPROVE_OPTION) {
            try{
               //获取当前目录
               File dir=fileDialog.getCurrentDirectory();
               //拿到选择的文件名
               String name=fileDialog.getSelectedFile().getName();
               // 创建文件对象
               File file=new File(dir,name);
               //将图片文件设置给 Advertisement
               ad.setPictureFile(file);
            }
            catch(Exception exp){}
         }
      }
      //提交
      if(e.getSource()==view.submit) {
         // 拿到提交的内容
         String number = view.inputSerialNumber.getText();
         String content = view.inputWord.getText();
         ad.setContent(content);
         ad.setSerialNumber(number);
         // 添加到数据库
         boolean boo = addAdvertisement.addAdvertisement(ad);
         if(boo)
            view.hintMess.setText("添加成功");
         else
            view.hintMess.setText("添加失败");
      }
   }


}