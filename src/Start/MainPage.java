package Start;

import OperatingSystemTopics.Cryptography;
import Users.ClientPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class  MainPage extends JFrame
{
    public MainPage() throws IOException
    {
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(102, 102, 255));
        setSize(400,500);
        setLocation(500,110);
        setUndecorated(true);
        getContentPane().setLayout(null);
        _init_();
        setVisible(true);
    }
    public static void main(String[] args) throws IOException
    {
        new MainPage();
    }
    public void _init_() throws IOException
    {
        ImageIcon img = new ImageIcon(new ImageIcon(MainPage.class.getResource("/icons/img1.jpg")).getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT));
        FileWriter fw = new FileWriter(new File("accounts.txt"),true);
        fw.close();
        
        JLabel image = new JLabel(img);
        image.setBounds(0,0,400,200);
        image.setLayout(null);

        JLabel title = new JLabel("Open Diary");
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,35));
        title.setBounds(200,85,200,100);
        image.add(title);
        getContentPane().add(image);

        JLabel usernamelabel = new JLabel("Username");
        usernamelabel.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        usernamelabel.setBounds(160,240,150,30);
        getContentPane().add(usernamelabel);

        JLabel passwordl = new JLabel("Password");
        passwordl.setFont(new Font(Font.DIALOG,Font.BOLD,14));
        passwordl.setBounds(160,310,150,30);
        getContentPane().add(passwordl);

        JTextField username = new JTextField();
        username.setBounds(70,270,260,30);
        getContentPane().add(username);

        JPasswordField password = new JPasswordField();
        password.setBounds(70,340,260,30);
        getContentPane().add(password);

        JButton login = new JButton("LOGIN");
        login.setBounds(70,400,260,40);
        login.setFont(new Font(Font.DIALOG,Font.BOLD,18));
        login.setBackground(new Color(41, 82, 163));
        login.setForeground(Color.white);
        getContentPane().add(login);

        JButton signup = new JButton("<html><u>Create account</u>  |</html>");
        signup.setBackground(new Color(102, 102, 255));
        signup.setFont(new Font(Font.DIALOG,Font.BOLD,16));
        signup.setBounds(70,465,160,30);
        getContentPane().add(signup);
        signup.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
                new SignUpPage();
                dispose();
              }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
        });

        JButton exit = new JButton("<html><u> Exit</u></html>");
        exit.setFont(new Font(Font.DIALOG,Font.BOLD,16));
        exit.setBackground(new Color(102, 102, 255));
        exit.setBounds(220,465,100,30);
        getContentPane().add(exit);
        JLabel iba = new JLabel("Sukkur IBA University");
        getContentPane().add(iba);
        iba.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        iba.setForeground(Color.white);
        iba.setBounds(27,144,350,60);
        exit.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
        });
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					if(Check_Data(username.getText(),new String(password.getPassword())))
					{
					    new ClientPage(username.getText());
					    dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Incorrect email OR password");
						username.setText("");
						password.setText("");
					}
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				}
            }
        });
    }
    public boolean Check_Data(String email,String password) throws FileNotFoundException
    {
        Scanner rf = new Scanner(new File("accounts.txt"));
        while(rf.hasNext())
        {
        	String fileEmail = rf.next();
        	String filePassword = rf.next();
        	fileEmail = Cryptography.decrypt(fileEmail);
        	filePassword = Cryptography.decrypt(filePassword);
        	if(fileEmail.equals(email) && filePassword.equals(password))
        	{
        		return true;
        	}
        }
        rf.close();
        return false;
    }
}