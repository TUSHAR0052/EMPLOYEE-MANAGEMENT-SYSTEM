package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addEmployee extends JFrame implements ActionListener {

    Random rand = new Random();
    int num = rand.nextInt(999999);
    JTextField tname, tfname, taadress, tphone, taadhaar, temail, tsalary, tdesignation ;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox teducation;
    JButton add,back;

    addEmployee() {

        //HEADING CONFIG
        getContentPane().setBackground(new Color(163, 255, 188));
        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(285, 50, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // DETAILS LABEL CONFIG

        //NAME
        JLabel name = new JLabel("NAME: ");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);
        tname = new JTextField();
        tname.setBounds(225, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        // FATHER NAME
        JLabel fname = new JLabel("FATHER'S NAME: ");
        fname.setBounds(425, 150, 190, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);
        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        //DOB
        JLabel dob = new JLabel("DATE OF BIRTH: ");
        dob.setBounds(50, 225, 200, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);
        tdob = new JDateChooser();
        tdob.setBounds(225,225,150,30);
        tdob.setBackground(new Color(177,252,197));
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
        taadress.setBounds(225, 300, 150, 30);
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
        temail.setBounds(225, 375, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        //EDUCATION
        JLabel education = new JLabel("EDUCATION: ");
        education.setBounds(425, 375, 225, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);
        String items[] = {"BBA","BTech","BCA","BCom","BSc","MBA","MCA","MA","MTech","MSc","PhD"};
        teducation = new JComboBox(items);
        teducation.setBackground(new Color(177,252,197));
        teducation.setBounds(600,375,150,30);
        add(teducation);

        //AADHAAR
        JLabel aadhaar = new JLabel("AADHAAR NO.: ");
        aadhaar.setBounds(50, 450, 190, 30);
        aadhaar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhaar);
        taadhaar = new JTextField();
        taadhaar.setBounds(225, 450, 150, 30);
        taadhaar.setBackground(new Color(177, 252, 197));
        add(taadhaar);

        //EMPLOYEE ID
        JLabel EmpId = new JLabel("EMPLOYEE ID: ");
        EmpId.setBounds(50, 525, 190, 30);
        EmpId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(EmpId);
        tempid = new JLabel(""+num);
        tempid.setBounds(225, 525, 150, 30);
        //tempid.setBackground(new Color(177, 252, 197));
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
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

        // add and back buttons
        add = new JButton("ADD");
        add.setBounds(450,590,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        back = new JButton("BACK");
        back.setBounds(220,590,150,40);
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
        new addEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            // Retrieve input values
            String name = tname.getText().trim();
            String fname = tfname.getText().trim();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText().trim();
            String salary = tsalary.getText().trim();
            String address = taadress.getText().trim();
            String aadhaar = taadhaar.getText().trim();
            String phone = tphone.getText().trim();
            String email = temail.getText().trim();
            String education = (String)teducation.getSelectedItem();
            String designation = tdesignation.getText().trim();
            String EmpId = tempid.getText().trim();

            // Validation
            boolean isValid = true;
            StringBuilder errorMessage = new StringBuilder();

            // Validate name, father's name, address, and designation (letters and spaces allowed)
            if (!name.matches("[a-zA-Z ]+")) {
                errorMessage.append("Name can only contain letters and spaces.\n");
                isValid = false;
            }
            if (!fname.matches("[a-zA-Z ]+")) {
                errorMessage.append("Father's name can only contain letters and spaces.\n");
                isValid = false;
            }
            if (!address.matches("[a-zA-Z ]+")) {
                errorMessage.append("Address can only contain letters and spaces.\n");
                isValid = false;
            }
            if (!designation.matches("[a-zA-Z ]+")) {
                errorMessage.append("Designation can only contain letters and spaces.\n");
                isValid = false;
            }

            // Validate DOB (DD-MM-YYYY format)
            if (!dob.matches("\\d{2}-\\d{2}-\\d{4}")) {
                errorMessage.append("Date of Birth must be in DD-MM-YYYY format.\n");
                isValid = false;
            }

            // Validate Phone Number (numbers only)
            if (!phone.matches("\\d+")) {
                errorMessage.append("Phone Number can only contain numbers.\n");
                isValid = false;
            }

            // Validate email format
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                errorMessage.append("Email is not in a valid format.\n");
                isValid = false;
            }

            // Check if validation passed
            if (isValid) {
                try {
                    conn c = new conn();
                    String query = "INSERT INTO employee (name, fname, dob, salary, address, phone, email, education, designation, empid, aadhaar) VALUES('"
                            + name + "','" + fname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','"
                            + designation + "','" + EmpId + "','" + aadhaar + "')";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "DETAILS ADDED SUCCESSFULLY");
                    setVisible(false);
                    new Main_class();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Show validation errors
                JOptionPane.showMessageDialog(null, errorMessage.toString(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }
}
