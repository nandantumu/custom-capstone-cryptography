import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nandan on 2/8/2016.
 */
public class HomeScreen {
    public HomeScreen() {
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EncryptScreen.main();
                (((JButton)e.getSource()).getRootPane()).setVisible(false);
                ((JButton) e.getSource()).getRootPane().updateUI();
            }
        });
    }

    public static void main() {
        JFrame frame = new JFrame("HomeScreen");
        frame.setContentPane(new HomeScreen().MainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton createAKeyButton;
    private JButton encryptButton;
    private JButton decryptButton;
    private JPanel MainFrame;
    private JPanel EncDecButtonContainer;

}
