package view;

import Model.Advertisement;
import Model.AdvertisingBoard;
import Model.Login;
import utils.ModifyAdvertisement;
import utils.QueryOneUserAD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class ModifyAdvertisementView extends JPanel {

    public Login login;
    JButton modify;
    JButton select;
    public AdvertisingBoardView  pCenter ;

    QueryOneUserAD query;

    ModifyAdvertisement modifyAdvertisement;
    Advertisement ad;

    public JButton inputPictureFile;

    ModifyAdvertisementView() {
        modifyAdvertisement = new ModifyAdvertisement();

        ad = new Advertisement();
        initView();
    }
    public void setLogin(Login login){
        this.login = login;
    }
    private void initView() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        pCenter = new AdvertisingBoardView();
        inputPictureFile = new JButton("选择广告图像文件");
        modify = new JButton("修改");

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyAdv(e);
            }
        });

        inputPictureFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyAdv(e);
            }
        });
        select = new JButton("查询");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestDate();
            }
        });

        pNorth.add(inputPictureFile);
        pNorth.add(select);
        pNorth.add(modify);
        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
    }

    private void requestDate() {
        if(login.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        query = new QueryOneUserAD();
        query.setLogin(login);
        Advertisement[] ad = query.queryOneUser(login.getId());
        if(ad == null ) {
            JOptionPane.showMessageDialog
                    (null,"你没有发布广告","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AdvertisingBoard board = new AdvertisingBoard();
        board.setAdvertisement(ad);
        pCenter.setAdvertisingBoard(board);
        pCenter.next.doClick();
    }

    private void modifyAdv(ActionEvent e) {
        if(login.getLoginSuccess() == false){
            JOptionPane.showMessageDialog
                    (null,"请先登录","消息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(e.getSource()==inputPictureFile) {
            JFileChooser fileDialog=new JFileChooser();
            int state=fileDialog.showOpenDialog(null);
            if(state==JFileChooser.APPROVE_OPTION) {
                try{
                    File dir=fileDialog.getCurrentDirectory();
                    String name=fileDialog.getSelectedFile().getName();
                    File file=new File(dir,name);
                    ad.setPictureFile(file);
                    InputStream in= new FileInputStream(ad.getPictureFile());
                    int length=in.available();
                    byte [] b=new byte[length];
                    in.read(b);
                    in.close();
                    Image img=Toolkit.getDefaultToolkit().createImage(b);
                    ad.setImage(img);
                    pCenter.showImage.setImage(ad.getImage());
                    pCenter.showImage.repaint();
                }
                catch(Exception exp){}
            }
        }
        if(e.getSource()==modify) {
            // 拿到提交的内容
            String number = pCenter.showID.getText() + pCenter.showNumber.getText();
            String content = pCenter.showContent.getText();
            ad.setContent(content);
            ad.setSerialNumber(number);
            // 更新到数据库
            modifyAdvertisement.setLogin(login);
            int i = modifyAdvertisement.modifyAdvertisement(ad);
            if(i > 0)
                JOptionPane.showMessageDialog
                        (null,"更新成功","消息对话成功框", JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog
                        (null,"更新失败","消息对话成功框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
