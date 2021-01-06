package manage;

import Model.Manage;
import view.RegisterView;

import javax.swing.*;
import java.awt.*;


public class ManageView extends JFrame {

    JTabbedPane tabbedPane;
    Manage manage;

    DelAdvertisementView delAdvertisementView;
    ManageLoginView loginView;
    ManageRegisterView registerView;
    ManageModifyPassword manageModifyPassword;
    DelUserView delUserView;

    public ManageView(){
        this.setTitle("管理员界面");
        manage = new Manage();
        delAdvertisementView = new DelAdvertisementView();
        delAdvertisementView.setLogin(manage);
        manageModifyPassword = new ManageModifyPassword();
        manageModifyPassword.setLogin(manage);
        delUserView = new DelUserView();
        delUserView.setLogin(manage);
        registerView = new ManageRegisterView();



        loginView = new ManageLoginView();
        loginView.setManage(manage);
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.add("登录",loginView);
        tabbedPane.add("注册",registerView);
        tabbedPane.add("删除用户",delUserView);
        tabbedPane.add("删除广告",delAdvertisementView);
        tabbedPane.add("修改密码",manageModifyPassword);
        tabbedPane.validate();
        //剧中布局
        add(tabbedPane, BorderLayout.CENTER);
        //设置窗体的出现位置以及大小
        setBounds(100,100,1200,560);
        //重新布局，让组件能正常显示出来
        validate();
        //点击窗体右上角的叉会退出程序
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置窗体可见
        setVisible(true);
    }
}
