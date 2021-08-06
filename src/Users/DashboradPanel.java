package Users;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DashboradPanel extends JPanel
{
    public static JLabel dashboard;
    public static JLabel d1icon;

    DashboradPanel()
    {
        setBounds(200,5,745,690);
        setBackground(Color.LIGHT_GRAY);
        _init_();
        Info();
    }
    private void _init_()
    {
        ImageIcon d1 = new ImageIcon(new ImageIcon(DashboradPanel.class.getResource("/icons/Dashboard.png")).getImage().getScaledInstance(25,25,5));
        d1icon = new JLabel(d1);
        d1icon.setBounds(10,250,25,25);
        dashboard = new JLabel("       Dashboard");
        dashboard.setBounds(0,230,200,70);
        dashboard.setBackground(new Color(70, 22, 255));
        dashboard.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        dashboard.setBorder(new LineBorder(new Color(70, 32, 255),5,false));
        dashboard.addMouseListener(new Changer());
    }
    public void Info(){
        setLayout(null);
        JLabel lblWhichServiceWould = new JLabel("Which service would you want to utilize?");
        lblWhichServiceWould.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        lblWhichServiceWould.setBounds(145,5,454,33);
        this.add(lblWhichServiceWould);
        
        JButton Google = new JButton("New button");
        Google.setIcon(new ImageIcon(DashboradPanel.class.getResource("/icons/serv1.jpg")));
        Google.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.google.com"));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
        		thread.start();
        	}
        });
        Google.setBounds(61, 94, 273, 207);
        add(Google);
        
        JButton Facebook = new JButton("New button");
        Facebook.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.facebook.com"));
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
                thread.start();
        	}
        });
        Facebook.setIcon(new ImageIcon(DashboradPanel.class.getResource("/icons/serv2.jpg")));
        Facebook.setBounds(424, 94, 273, 207);
        add(Facebook);
        
        JButton Youtube = new JButton("New button");
        Youtube.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.youtube.com"));
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
                thread.start();
        	}
        });
        Youtube.setIcon(new ImageIcon(DashboradPanel.class.getResource("/icons/serv3.jpg")));
        Youtube.setBounds(61, 370, 273, 207);
        add(Youtube);

        JButton Instagram = new JButton("New button");
        Instagram.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.instagram.com"));
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
                thread.start();
        	}
        });
        Instagram.setIcon(new ImageIcon(DashboradPanel.class.getResource("/icons/serv4.jpg")));
        Instagram.setBounds(424, 370, 273, 207);
        add(Instagram);
    }
}