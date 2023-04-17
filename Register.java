package LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JTextField tfName;
    private JTextField emailText;
    private JTextField noTelp;
    private JPasswordField password;
    private JButton btnRegister;
    private JButton btnCancel;
    private JLabel usernameLabel;
    private JPanel panel2;
    private JFrame frame2;

    public Register(){

        frame2=new JFrame("Register Frame");
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setPreferredSize(new Dimension(550, 300));
        frame2.setResizable(false);

        //now add the panel
        frame2.add(panel2);

        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
