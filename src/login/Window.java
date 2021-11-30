package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class Window
{
    private final Map<String, User> Database = new HashMap<>();
    JFrame AppFrame;
    JTextField loginBox;
    JPasswordField passwordBox;

    Window()
    {
        this.AppFrame = createFrame();
        this.loginBox = createTextField();
        this.passwordBox = createPasswordField();

        JLabel login = createTextField("Login:");
        login.setBounds(160,200,75,30);

        JLabel password = createTextField("Password:");
        password.setBounds(133,260,75,30);

        JButton exit = createButton("Exit");
        exit.setBounds(380,350,100,40);
        exit.addActionListener(e -> exitButtonPressed());

        JButton log = createButton("Log In");
        log.setBounds(120,350,100,40);
        log.addActionListener(this::loginButtonPressed);

        JButton clear = createButton("Clear");
        clear.setBounds(250,350,100,40);
        clear.addActionListener(e -> clearTextFields());

        AppFrame.getRootPane().setDefaultButton(log);
        AppFrame.add(login);
        AppFrame.add(password);
        AppFrame.add(loginBox);
        AppFrame.add(passwordBox);
        AppFrame.add(log);
        AppFrame.add(clear);
        AppFrame.add(exit);
        addUsers(Database);
    }

    private JFrame createFrame()
    {
        JFrame frame = new JFrame("UserApp");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.white);
        return frame;
    }

    private JButton createButton(String text)
    {
        JButton button = new JButton(text);
        button.setSize(50,10);
        button.setFocusable(false);
        return button;
    }

    private void loginButtonPressed(ActionEvent actionEvent)
    {
        String login = this.loginBox.getText();
        String password = String.valueOf(this.passwordBox.getPassword());
        if(Database.containsKey(login))
        {
            if (Database.get(login).getPassword().equals(password))
                accessPermitted();
            else
                accessDenied();
        }
        else
            accessDenied();
    }

    private void accessPermitted()
    {
        AppFrame.getContentPane().setBackground(Color.green);
        JOptionPane.showMessageDialog(AppFrame, "Correct login and password!", "Login succeed!", JOptionPane.INFORMATION_MESSAGE);
        AppFrame.getContentPane().setBackground(Color.white);
        clearTextFields();
    }

    private void accessDenied()
    {
        AppFrame.getContentPane().setBackground(Color.red);
        JOptionPane.showMessageDialog(AppFrame,"Incorrect login or password!", "Login failed!", JOptionPane.WARNING_MESSAGE);
        AppFrame.getContentPane().setBackground(Color.white);
        passwordBox.setText(null);
    }

    private void clearTextFields()
    {
        loginBox.setText(null);
        passwordBox.setText(null);
    }

    private JTextField createTextField()
    {
        JTextField loginField = new JTextField();
        loginField.setBounds(200,200,200,30);
        loginField.setBorder(BorderFactory.createLineBorder(Color.black,1));
        return loginField;
    }

    private JPasswordField createPasswordField()
    {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 260,200,30);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black,1));
        return passwordField;
    }

    private JLabel createTextField(String text)
    {
        JLabel label = new JLabel(text);
        label.setVisible(true);
        label.setBackground(Color.white);
        return label;
    }

    private void addUsers(Map<String, User> UserBase)
    {
        User user1 = new User("root", "toor");
        UserBase.put(user1.getLogin(), user1);
        User user2 = new User("user", "123456");
        UserBase.put(user2.getLogin(), user2);
        User user3 = new User("login", "haslo");
        UserBase.put(user3.getLogin(), user3);
        User user4 = new User("sudo", "su");
        UserBase.put(user4.getLogin(), user4);
        User user5 = new User("java", "swing");
        UserBase.put(user5.getLogin(), user5);
    }

    private void exitButtonPressed()
    {
        System.exit(0);
    }
}
