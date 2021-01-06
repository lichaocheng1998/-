package view;
import Model.Login;

import javax.swing.*;
import java.awt.*;

/**
 * 添加广告
 */
public class AddAdvertisementView extends JPanel {
   public Login login;
   public JTextField inputSerialNumber;  
   public JTextArea inputWord;         
   public JButton inputPictureFile;     
   public JButton submit;              
   public JTextField hintMess; 
   HandleAddAdvertisement handleAddAdvertisement;

   AddAdvertisementView() {
      initView();
      registerListener() ;
   }
   public void setLogin(Login login){
      this.login = login;
   }
   private void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      JPanel pSouth = new JPanel();
      hintMess = new JTextField(20);
      //设置不可编辑
      hintMess.setEditable(false);
      inputSerialNumber = new JTextField(20);
      inputWord = new JTextArea();
      inputWord.setLineWrap(true);
      inputWord.setWrapStyleWord(true);
      inputWord.setFont(new Font("宋体",Font.BOLD,20));
      inputPictureFile = new JButton("选择广告图像文件");
      submit = new JButton("添加广告");
      //往 pNorth 放入一个 label
      pNorth.add(new JLabel("请输入广告序列号"));
      pNorth.add(inputSerialNumber);
      pNorth.add(new JLabel("在文本区输入广告词"));

      pSouth.add(inputPictureFile);
      pSouth.add(submit);
      pSouth.add(hintMess);
      add(pNorth,BorderLayout.NORTH);
      add(pSouth,BorderLayout.SOUTH);
      add(new JScrollPane(inputWord),BorderLayout.CENTER);
   }

   private void registerListener() {
      handleAddAdvertisement = new HandleAddAdvertisement();
      handleAddAdvertisement.setView(this);
      submit.addActionListener(handleAddAdvertisement);
      inputPictureFile.addActionListener(handleAddAdvertisement);
   }
}