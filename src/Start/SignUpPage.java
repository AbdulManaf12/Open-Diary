package Start;

import OperatingSystemTopics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpPage extends JFrame
{
    public SignUpPage()
    {
        getContentPane().setBackground(new Color(102, 102, 255));
        setSize(400,500);
        setLocation(500,110);
        setUndecorated(true);
        setLayout(null);
        _init_();
        setVisible(true);
    }
    public void _init_()
    {
        ImageIcon img = new ImageIcon(new ImageIcon(SignUpPage.class.getResource("/icons/img1.jpg")).getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT));

        JLabel image = new JLabel(img);
        image.setBounds(0,0,400,200);
        image.setLayout(null);
 
        add(image);

        JLabel namel = new JLabel("Name");
        namel.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        namel.setBounds(165,210,150,30);
        add(namel);

        JLabel dobl = new JLabel("Birth Date");
        dobl.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        dobl.setBounds(155,265,150,30);
        add(dobl);

        JLabel emaill = new JLabel("Email");
        emaill.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        emaill.setBounds(165,320,150,30);
        add(emaill);

        JLabel passwordl = new JLabel("Password");
        passwordl.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        passwordl.setBounds(160,375,150,30);
        add(passwordl);

        JTextField name = new JTextField();
        name.setBounds(70,240,260,25);
        add(name);

        JTextField dob = new JTextField();
        dob.setBounds(70,295,260,25);
        add(dob);

        JTextField email = new JTextField();
        email.setBounds(70,350,260,25);
        add(email);

        JPasswordField password = new JPasswordField();
        password.setBounds(70,405,260,25);
        add(password);

        JButton back = new JButton("Back");
        back.setBounds(80,445,100,30);
        back.setFont(new Font(Font.DIALOG,Font.BOLD,18));
        back.setBackground(new Color(41, 82, 163));
        back.setForeground(Color.white);
        add(back);

        JButton signup = new JButton("Signup");
        signup.setBounds(210,445,100,30);
        signup.setFont(new Font(Font.DIALOG,Font.BOLD,18));
        signup.setBackground(new Color(41, 82, 163));
        signup.setForeground(Color.white);
        add(signup);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					new MainPage();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
                dispose();
            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					if(insert_Data(name.getText(),dob.getText(),email.getText(),new String(password.getPassword()))){
					    name.setText("");
					    dob.setText("");
					    email.setText("");
					    password.setText("");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

    }
    public boolean insert_Data(String name, String dob,String email,String password) throws IOException
    {
        if (!name.isEmpty() && !dob.isEmpty() && !email.isEmpty() && !password.isEmpty())
        {
        	FileWriter fw = new FileWriter("accounts.txt",true);
        	fw.write(Cryptography.encrypt(email)+" "+Cryptography.encrypt(password)+" ");
        	
        	fw.close();
        	
            String request = "Signup("+name+","+dob+","+email+","+password+")";
            String t = Client.StartClient(request);
            if (t != null && t.equalsIgnoreCase("Done")){
            	
                JOptionPane.showMessageDialog(null,"Successfully created");
                return true;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
        return false;
    }
}
