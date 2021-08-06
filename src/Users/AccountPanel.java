package Users;

import OperatingSystemTopics.Client;
import OperatingSystemTopics.Constants;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AccountPanel extends JPanel
{
    public static JLabel account;
    public static JLabel d2icon;
    public static String arr[];

    AccountPanel()
    {
        setBounds(200,5,745,690);
        setBackground(Color.darkGray);
        setLayout(null);
        _init_();
        _init_1();
    }
    private void _init_()
    {
        ImageIcon d2 = new ImageIcon(new ImageIcon(AccountPanel.class.getResource("/icons/account.png")).getImage().getScaledInstance(25,25,5));
        d2icon = new JLabel(d2);
        d2icon.setBounds(10,315,25,25);

        account = new JLabel("       Account");
        account.setBounds(0,295,200,70);
        account.setBackground(new Color(70, 22, 255));
        account.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        account.setBorder(new LineBorder(new Color(70, 32, 255),5,false));
        account.addMouseListener(new Changer());
    }
    public void _init_1(){
        this.removeAll();
        ImageIcon img = new ImageIcon(new ImageIcon("src\\icons\\account.png").getImage().getScaledInstance(100,100,5));
        JLabel label1 = new JLabel(img);
        label1.setBounds(190,30,200,200);
        this.add(label1);
        arr = Client.StartClient("Get("+ClientPage.email+")").split(",");
        if (arr.length == 4) {
            JLabel name = new JLabel(arr[Constants.Name]);
            name.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 25));
            name.setBounds(250, 130, 400, 200);
            name.setForeground(Color.WHITE);
            this.add(name);

            JLabel dob = new JLabel(arr[Constants.DOB]);
            dob.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 25));
            dob.setBounds(250, 200, 400, 200);
            dob.setForeground(Color.WHITE);
            this.add(dob);

            JLabel email = new JLabel(arr[Constants.Email]);
            email.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 25));
            email.setBounds(240, 270, 400, 200);
            email.setForeground(Color.WHITE);
            this.add(email);
        }
    }
}