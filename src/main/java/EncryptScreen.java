import javax.swing.*;
import java.awt.*;

/**
 * Created by Nandan on 2/10/2016.
 */
public class EncryptScreen {
    private JPanel panel1;
    private JButton button1;

    public static void main() {
        JFrame frame = new JFrame("EncryptScreen");
        frame.setContentPane(new EncryptScreen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton encryptButton;

}
