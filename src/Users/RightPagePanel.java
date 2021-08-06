package Users;

import OperatingSystemTopics.Client;
import Start.MainPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RightPagePanel extends JPanel
{
    private ClientPage p;

    public RightPagePanel(ClientPage p)
    {
        this.p = p;
        setBounds(5,5,200,690);
        setBackground(new Color(70, 22, 255));
        setLayout(null);
        addMouseListener(new Changer());
        _init_();
    }
    private void _init_()
    {
        ImageIcon img = new ImageIcon(new ImageIcon(RightPagePanel.class.getResource("/icons/account.png")).getImage().getScaledInstance(100,100,5));
        JLabel Profile = new JLabel(img);
        Profile.setBounds(45,30,100,100);
        add(Profile);

        JLabel Name = new JLabel(Client.StartClient("Get("+ClientPage.email+")").split(",")[0]);
        Name.setBounds(50,135,300,30);
        Name.setBackground(new Color(70, 22, 255));
        Name.setFont(new Font(Font.DIALOG,Font.BOLD,18));
        add(Name);

        JLabel cms = new JLabel(ClientPage.email);
        cms.setBounds(20,165,300,30);
        cms.setBackground(new Color(70, 22, 255));
        cms.setFont(new Font(Font.DIALOG,Font.PLAIN,16));
        add(cms);

        add(DashboradPanel.d1icon);
        add(DashboradPanel.dashboard);
        add(AccountPanel.d2icon);
        add(AccountPanel.account);

        ImageIcon imgs = new ImageIcon(new ImageIcon(RightPagePanel.class.getResource("/icons/logout.png")).getImage().getScaledInstance(50,50,5));
        JButton logout = new JButton(imgs);
        logout.setBackground(new Color(70, 22, 255));
        logout.setBorder(null);
        logout.setBounds(70,600,50,50);
        add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					new MainPage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                ClientPage.email = "";
                p.dispose();
            }
        });
    }
}