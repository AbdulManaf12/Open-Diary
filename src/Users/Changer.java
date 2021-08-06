package Users;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Changer implements MouseListener
{
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource() == DashboradPanel.dashboard)
        {
            ClientPage.cardLayout.show(ClientPage.panelGroup,"dashbroad");
        }
        else if (e.getSource() == AccountPanel.account)
        {
            ClientPage.accountPanel._init_1();
            ClientPage.cardLayout.show(ClientPage.panelGroup,"account");
        }
        else
        {
            ClientPage.cardLayout.show(ClientPage.panelGroup,"White");
        }
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
