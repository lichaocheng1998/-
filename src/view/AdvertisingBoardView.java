package view;
import Model.Advertisement;
import Model.AdvertisingBoard;
import Model.Login;
import utils.ModifyAdvertisement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class AdvertisingBoardView extends JPanel {
   AdvertisingBoard advertisingBoard;
   public JTextArea showContent;       
   public ImageJPanel showImage;       
   public JButton next,previous;     
   public JLabel showID   ;                
   public JLabel showNumber ;               
   HandleAdvertisingBoard handleAdvertisingBoard;

   public AdvertisingBoardView() {
      //初始化试图
      initView();
      registerListener();
   } 
   public void initView() {
      //设置边框布局
      setLayout(new BorderLayout());
      //图片组件
      showImage = new ImageJPanel();
      // 文本域
      showContent = new JTextArea(12,12);
      //设置当鼠标停留的时候展示的文本
      showContent.setToolTipText("在图片上单击鼠标可调整观看");
      //设置字体颜色
      showContent.setForeground(Color.blue);
      //设置自动换行的方式
      showContent.setWrapStyleWord(true);
      //是否自动换行
      showContent.setLineWrap(true);
      //设置字体
      showContent.setFont(new Font("宋体",Font.BOLD,18));
      next = new JButton("下一个广告");
      previous = new JButton("上一个广告");

      JPanel pNorth = new JPanel();
      pNorth.setBackground(Color.cyan) ;
      showID = new JLabel();
      showNumber = new JLabel();
      pNorth.add(new JLabel("发布者的ID"));
      pNorth.add(showID);
      pNorth.add(new JLabel("广告的序列号"));
      pNorth.add(showNumber);
      //设置边框北布局
      add(pNorth,BorderLayout.NORTH);
      JPanel pCenter = new JPanel();
      //设置为网格布局，一行两列
      pCenter.setLayout(new GridLayout(1,2));
      pCenter.add(new JScrollPane(showContent));
      pCenter.add(showImage);
      add(pCenter,BorderLayout.CENTER);

      JPanel pSouth = new JPanel();
      pSouth.add(next);
      pSouth.add(previous);
      // 南布局
      add(pSouth,BorderLayout.SOUTH);
      //重新构建，让组件正常显示
      validate();
   }
   public void registerListener(){
      handleAdvertisingBoard = new HandleAdvertisingBoard();
      //给 下一个和上一个添加事件
      next.addActionListener(handleAdvertisingBoard);
      previous.addActionListener(handleAdvertisingBoard);
      //传递视图
      handleAdvertisingBoard.setView(this);
   }
   public void setAdvertisingBoard(AdvertisingBoard advertisingBoard) {
      this.advertisingBoard = advertisingBoard;
   }


}
