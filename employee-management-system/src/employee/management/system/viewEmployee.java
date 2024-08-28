package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEmp;
    JButton searchbtn, print, update, back;

    viewEmployee() {

        getContentPane().setBackground(new Color(255, 131, 122));
        //SEARCH BY EMP ID
        JLabel search = new JLabel("SEARCH BY EMP ID : ");
        search.setBounds(20, 20, 150, 20);
        add(search);
        // FOR DROPDOWN MENU OF EMPLOYEE SEARCH
        choiceEmp = new Choice();
        choiceEmp.setBounds(180, 20, 150, 20);
        add(choiceEmp);
        // FOR QUERY EVALUATION AND EXCEPTION
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEmp.add(resultSet.getString("EmpId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // table
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        //BUTTONS
        //SEARCH BUTTON
        searchbtn = new JButton("SEARCH");
        searchbtn.setBounds(20, 70, 100, 20);
        add(searchbtn);
        searchbtn.addActionListener(this);
        //PRINT BUTTON
        print = new JButton("PRINT");
        print.setBounds(120, 70, 100, 20);
        add(print);
        print.addActionListener(this);
        //UPDATE BUTTON
        update = new JButton("UPDATE");
        update.setBounds(220, 70, 100, 20);
        add(update);
        update.addActionListener(this);
        //BACK BUTTON
        back = new JButton("BACK");
        back.setBounds(320, 70, 100, 20);
        add(back);
        back.addActionListener(this);


        // VIEW WINDOW CONFIG
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new viewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            String query = "select * from employee where EmpId = '" + choiceEmp.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
        setVisible(false);
        new updateEmployee(choiceEmp.getSelectedItem());
        } else {
        setVisible(false);
        new Main_class();
        }
    }
}
