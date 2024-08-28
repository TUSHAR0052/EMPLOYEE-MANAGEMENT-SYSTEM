package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    //VARIABLE INSTANTIATION
    JTextField tUserName;
    JPasswordField tPassword;
    JButton login , back;
    login() {

        //USERNAME LABEL
        JLabel username = new JLabel("USERNAME: ");
        username.setBounds(40, 20, 100, 30);
        add(username);

        //USERNAME TEXT FIELD
        tUserName = new JTextField();
        tUserName.setBounds(150,20,150,30);
        add(tUserName);

        //PASSWORD LABEL
        JLabel password = new JLabel("PASSWORD: ");
        password.setBounds(40, 70, 100, 30);
        add(password);

        //PASSWORD TEXT FIELD
        tPassword = new JPasswordField();
        tPassword.setBounds(150,70,150,30);
        add(tPassword);

        //LOGIN BUTTON
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        //BACK BUTTON
        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        //BG IMAGE
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(340,5,600,400);
        add(imgg);

        //ID LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        //LOGIN WINDOW CONFIG
        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==login){
            try{
                String username = tUserName.getText();
                String password = tPassword.getText();

                conn conn = new conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";

                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }
                else {
                    JOptionPane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource()==back){
            System.exit(90);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
