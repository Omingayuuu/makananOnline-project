import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    private JPanel panel1;
    private JTextField userText;
    private JPasswordField password;
    private JButton registerButton;
    private JButton loginButton;import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Login extends JDialog {
        private JPanel panel1;
        private JTextField tfEmail;
        private JButton btnLogin;
        private JButton btnCancel;
        private JPasswordField psPassword;

        public Login (JFrame parent) {
            super(parent);
            setTitle("Login");
            setContentPane(panel1);
            setMinimumSize(new Dimension(450, 474));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            public admin_dashboard() {
                btnLihatRestoran.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                btnTambahRestorant.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                btnHapusRestorant.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                btnLogout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
            }
        }
    }

        Admin admin;
        public Admin getAuthenticatedUser(String email, String password) {
            Admin admin = null;

            final String DB_URL = "jdbc:mysql://localhost/db_makanan_online?serverTimezone=UTC";
            final String USERNAME = "root";
            final String PASSWORD = "";

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                // Connection to database successfully

                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM users where email=? AND password=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);


                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String level = resultSet.getString("level");
                    if(level.equals("admin")) {
                        new dashboard_admin().setVisible(true);
                        dispose();
                    } else if (level.equals("customer")) {
                        new dashboard_customer().setVisible(true);
                        dispose();
                    }
                    admin = new Admin();
                    admin.nama = resultSet.getString("nama");
                    admin.email = resultSet.getString("email");
                    admin.no_telp = resultSet.getString("no_telp");
                    admin.alamat = resultSet.getString("alamat");
                    admin.password = resultSet.getString("password");
                    admin.level = resultSet.getString("level");
                }

                stmt.close();
                conn.close();

            }catch (Exception e){
                e.printStackTrace();
            }
            return admin;
        }

        public static void main (String[] args) {
            Login login = new Login(null);
            Admin admin = login.admin;
            if (admin != null){
                System.out.println("successfull authentication of : " + admin.nama);
                System.out.println("email" + admin.email);
                System.out.println("no_telp" + admin.no_telp);
                System.out.println("alamat" + admin.alamat);
                System.out.println("password"+ admin.password);
                System.out.println("level" + admin.level);
            } else {
                System.out.println("Authentication canceled");
            }
        }
    }
