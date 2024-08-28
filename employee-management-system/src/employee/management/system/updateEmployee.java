package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tfname, taadress, tphone, taadhaar, temail, tsalary, tdesignation;
    JLabel tempid;
    JButton updatebtn, back;
    String number;

    updateEmployee(String number) {

        this.number = number;

        //HEADING CONFIG
        getContentPane().setBackground(new Color(163, 255, 188));
        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(285, 50, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // DETAILS LABEL CONFIG

        //NAME
        JLabel name = new JLabel("NAME: ");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);
        JLabel tname = new JLabel();
        tname.setBounds(225, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        // FATHER NAME
        JLabel fname = new JLabel("FATHER'S NAME: ");
        fname.setBounds(425, 150, 190, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);
        JLabel tfname = new JLabel();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        //DOB
        JLabel dob = new JLabel("DATE OF BIRTH: ");
        dob.setBounds(50, 225, 200, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);
        JLabel tdob = new JLabel();
        tdob.setBounds(215, 225, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tdob);

        //SALARY
        JLabel salary = new JLabel("SALARY: ");
        salary.setBounds(425, 225, 190, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(600, 225, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        //ADDRESS
        JLabel address = new JLabel("ADDRESS: ");
        address.setBounds(50, 300, 190, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);
        taadress = new JTextField();
        taadress.setBounds(215, 300, 150, 30);
        taadress.setBackground(new Color(177, 252, 197));
        add(taadress);

        //PHONE NO.
        JLabel phone = new JLabel("PHONE NO: ");
        phone.setBounds(425, 300, 190, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);
        tphone = new JTextField();
        tphone.setBounds(600, 300, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        //EMAIL
        JLabel email = new JLabel("EMAIL: ");
        email.setBounds(50, 375, 190, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);
        temail = new JTextField();
        temail.setBounds(215, 375, 185, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        //EDUCATION
        JLabel education = new JLabel("EDUCATION: ");
        education.setBounds(425, 375, 225, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);
        JLabel teducation = new JLabel();
        teducation.setBounds(600, 375, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        //AADHAAR
        JLabel aadhaar = new JLabel("AADHAAR NO.: ");
        aadhaar.setBounds(50, 450, 190, 30);
        aadhaar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhaar);
        JLabel taadhaar = new JLabel();
        taadhaar.setBounds(215, 450, 190, 35);
        taadhaar.setBackground(new Color(177, 252, 197));
        add(taadhaar);

        //EMPLOYEE ID
        JLabel EmpId = new JLabel("EMPLOYEE ID: ");
        EmpId.setBounds(50, 525, 190, 30);
        EmpId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(EmpId);
        tempid = new JLabel();
        tempid.setBounds(215, 525, 150, 30);
        //tempid.setBackground(new Color(177, 252, 197));
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        //DESIGNATION
        JLabel designation = new JLabel("DESIGNATION: ");
        designation.setBounds(425, 450, 190, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);
        tdesignation = new JTextField();
        tdesignation.setBounds(600, 450, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        try {
            conn c = new conn();
            String query = "select * from employee where EmpId = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taadress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhaar.setText(resultSet.getString("aadhaar"));
                tempid.setText(resultSet.getString("empid"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // add and back buttons
        updatebtn = new JButton("UPDATE");
        updatebtn.setBounds(450, 590, 150, 40);
        updatebtn.setBackground(Color.black);
        updatebtn.setForeground(Color.WHITE);
        updatebtn.addActionListener(this);
        add(updatebtn);
        back = new JButton("BACK");
        back.setBounds(220, 590, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //ADD EMPLOYEE WINDOW CONFIG
        setSize(900, 700);
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);


    }

    public static void main(String[] args) {
        new updateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updatebtn) {
            String salary = tsalary.getText();
            String address = taadress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String designation = tdesignation.getText();

            try{
                conn c = new conn();
                String query = "update employee set salary = '"+salary+"', address = '"+address+"' , phone = '"+phone+"' , email = '"+email+"' , designation = '"+designation+"' where EmpId = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"DETAILS UPDATED SUCCESSFULLY");
                setVisible(false);
                new Main_class();
            }
            catch(Exception E){
                E.printStackTrace();
            }
        } else {
            new viewEmployee();
            setVisible(false);
        }
    }
}
