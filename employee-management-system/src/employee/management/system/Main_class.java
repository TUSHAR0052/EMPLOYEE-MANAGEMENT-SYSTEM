package employee.management.system;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class() {
        //VARIABLE INSTANTIATION


        //IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        //LOGIN HEADING
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(310, 155, 500, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        //ADD BUTTON
        JButton add = new JButton("ADD EMPLOYEE");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        //VIEW BUTTON
        JButton view = new JButton("VIEW EMPLOYEE");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        //REMOVE BUTTON
        JButton remove = new JButton("REMOVE EMPLOYEE");
        remove.setBounds(330, 370, 160, 40);
        remove.setForeground(Color.white);
        remove.setBackground(Color.black);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new removeEmployee();
            setVisible(false);
            }
        });
        img.add(remove);

        //BACK BUTTON
        JButton back = new JButton("BACK");
        back.setBounds(565, 370, 150, 40);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        img.add(back);

        //MAIN WINDOW CONFIG
        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }

}
