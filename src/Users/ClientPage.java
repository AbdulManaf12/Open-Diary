package Users;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPage extends JFrame
{
    public static String email;

    public ClientPage(String email)
    {
        ClientPage.email = email;
        setSize(950,700);
        setLocation(250,40);
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        _init_();
        setVisible(true);
    }
    private void _init_()
    {
        JPanel fullPanel = new JPanel();
        fullPanel.setLayout(null);
        fullPanel.setBounds(0,0,950,700);
        fullPanel.setBorder(new LineBorder(Color.black,5,false));
        fullPanel.add(new RightPagePanel(this));

        JPanel p = new JPanel();
        p.setBounds(200,5,745,690);
        p.setLayout(null);
        p.setBackground(Color.WHITE);

        ImageIcon img = new ImageIcon(new ImageIcon(ClientPage.class.getResource("/icons/welcome.png")).getImage().getScaledInstance(745,690,Image.SCALE_DEFAULT));
        JLabel label = new JLabel(img);
        label.setBounds(0,0,745,690);
        label.setLayout(null);
        p.add(label);

        JLabel title = new JLabel("to Open Diary");
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,45));
        title.setBounds(200,400,300,100);
        label.add(title);

        JLabel desc = new JLabel("Connect with your friends through this application, Enjoy");
        desc.setFont(new Font(Font.SERIF,Font.BOLD,25));
        desc.setBounds(50,450,700,100);
        label.add(desc);

        ImageIcon img1 = new ImageIcon(new ImageIcon(ClientPage.class.getResource("/icons/Start.jpg")).getImage().getScaledInstance(150,40,Image.SCALE_DEFAULT));
        JButton start = new JButton(img1);
        start.setBounds(285,560,150,40);
        label.add(start);

        panelGroup.setBounds(200,5,745,690);
        panelGroup.setLayout(cardLayout);

        panelGroup.add(p,"White");
        panelGroup.add(dashboradPanel,"dashbroad");
        panelGroup.add(accountPanel,"account");

        cardLayout.show(panelGroup,"White");
        fullPanel.add(panelGroup);
        add(fullPanel);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientPage.cardLayout.show(ClientPage.panelGroup,"dashbroad");
            }
        });
    }
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel panelGroup = new JPanel();
    public static DashboradPanel dashboradPanel = new DashboradPanel();
    public static AccountPanel accountPanel = new AccountPanel();
}