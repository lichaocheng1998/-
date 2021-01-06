package view;
import Model.Login;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * 主页面
 */
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane;
    RegisterView  regisView;
    LoginView loginView;
    AddAdvertisementView addAdvertisementView;
    DelAdvertisementView delAdvertisementView;
    QueryAllUserADView  queryAllUserADView;
    QueryOneUserADView queryOneUserADView;
    Login login;
    ModifyPassword modifyPassword;
    ModifyAdvertisementView modifyAdvertisementView;
    public IntegrationView(){
        this.setTitle("用户界面");
        regisView = new RegisterView();
        login = new Login();
        loginView = new LoginView();
        addAdvertisementView = new AddAdvertisementView();
        delAdvertisementView = new DelAdvertisementView();
        queryAllUserADView = new QueryAllUserADView();
        queryOneUserADView = new QueryOneUserADView();
        modifyPassword = new ModifyPassword();
        modifyAdvertisementView = new ModifyAdvertisementView();
        loginView.setLogin(login);
        addAdvertisementView.setLogin(login);
        delAdvertisementView.setLogin(login);
        queryAllUserADView.setLogin(login);
        queryOneUserADView.setLogin(login);
        modifyPassword.setLogin(login);
        modifyAdvertisementView.setLogin(login);
        // 设置选项卡面板左侧对齐
        tabbedPane=
        new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.add("登录",loginView);
        tabbedPane.add("注册",regisView);
        tabbedPane.add("添加广告",addAdvertisementView);
        tabbedPane.add("修改广告",modifyAdvertisementView);
        tabbedPane.add("删除广告",delAdvertisementView);
        tabbedPane.add("浏览全部用户广告",queryAllUserADView);
        tabbedPane.add("浏览某个用户广告",queryOneUserADView);
        tabbedPane.add("修改密码",modifyPassword);
        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER);
        setBounds(100,100,1200,560);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}