package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import resources.ConnectionDB;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import resources.JavaHotel;

public class Login extends JavaHotel {

    private JTextField textUser;
    private JSeparator separatorTextUser;
    private JPasswordField textPass;
    private JSeparator separatorTextPass;
    private JLabel loginLabel;
    private JPanel loginButton;
    private JLabel wallpaper, footer, background;
    public static int idUser;
    public static String userName;
    private String user, pass;

    String img1, img2;

    public Login() {
        initParametersLogin();
        setFrameStatebar();
        initComponentsLogin();
        setWallpaper(wallpaper);

    }

    private void initParametersLogin() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
        setName("JFrame1");
        setUndecorated(true);
        setResizable(false);
        setSize(560, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    private void initComponentsLogin() {

        textUser = new JTextField();
        separatorTextUser = new JSeparator();
        textPass = new JPasswordField();
        separatorTextPass = new JSeparator();
        loginLabel = new JLabel();
        loginButton = new JPanel();
        wallpaper = new JLabel();
        footer = new JLabel();
        background = new JLabel();

        img1 = "login1.png";
        img2 = "login2.png";
        loginLabel.setSize(140, 40);
        loginLabel.setIcon(setIcon(loginLabel, img1));
        loginButton.setBackground(new Color(174, 204, 50));
        loginButton.setLayout(new BorderLayout(0, 0));
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                loginButtonMouseExited(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        loginButton.setBounds(350, 300, 140, 40);
        loginButton.add(loginLabel, BorderLayout.CENTER);
        getContentPane().add(loginButton);

        textUser.setFont(new Font("Roboto", 2, 18));
        textUser.setForeground(Color.GRAY);
        textUser.setHorizontalAlignment(JTextField.LEFT);
        textUser.setText("Enter your username");
        textUser.setCaretPosition(0);
        textUser.setOpaque(false);
        textUser.setBorder(null); // (new EmptyBorder(1, 1, 1, 1));
        textUser.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                textUserMousePressed(evt);
            }
        });
        textUser.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                textUserKeyPressed(evt);
            }
        });
        textUser.setBounds(20, 280, 210, 30);
        getContentPane().add(textUser);

        separatorTextUser.setBounds(20, 310, 210, 5);
        separatorTextUser.setBackground(Color.GRAY);
        getContentPane().add(separatorTextUser);

        textPass.setFont(new Font("Roboto", 0, 18)); // NOI18N
        textPass.setForeground(Color.GRAY);
        textPass.setHorizontalAlignment(JTextField.LEFT);
        textPass.setText("Enter your password");
        textPass.setOpaque(false);
        textPass.setBorder(null);
        textPass.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                textPassMousePressed(evt);
            }
        });
        textPass.setBounds(20, 330, 210, 30);
        getContentPane().add(textPass);

        separatorTextPass.setBounds(20, 360, 210, 5);
        separatorTextPass.setBackground(Color.GRAY);
        getContentPane().add(separatorTextPass);

        wallpaper.setBounds(309, 1, 250, 398);
        getContentPane().add(wallpaper);

        footer.setFont(new Font("Helvetica Now", 0, 12));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setText("© Created by WarDog1000 ");
        footer.setSize(400, 20);
        footer.setLocation(0, 520);
        getContentPane().add(footer);

        background.setBounds(0, 0, 560, 400);
        background.setOpaque(true);
        background.setBorder(new LineBorder(Color.WHITE, 1));
        background.setBackground(Color.BLACK);
        getContentPane().add(background);
    }

    private void textUserMousePressed(MouseEvent evt) {
        user = textUser.getText().trim();
        pass = textPass.getText().trim();
        if (user.trim().equals("Enter your username")) {
            textUser.setText("");
            textUser.setForeground(Color.WHITE);
            textUser.setFont(new Font("Roboto", 0, 18));
        }

        if (pass.trim().equals("")) {
            textPass.setText("Enter your password");
            textPass.setForeground(Color.GRAY);
        }
    }

    private void textUserKeyPressed(KeyEvent evt) {
        user = textUser.getText().trim();
        pass = textPass.getText().trim();
        if (user.trim().equals("Enter your username")) {
            textUser.setText("");
            textUser.setForeground(Color.WHITE);
        }
        textUser.setFont(new Font("Roboto", 0, 18));

    }

    private void textPassMousePressed(MouseEvent evt) {
        user = textUser.getText().trim();
        pass = textPass.getText().trim();
        if (pass.trim().equals("Enter your password")) {
            textPass.setText("");
            textPass.setForeground(Color.WHITE);
        }

        if (user.trim().equals("")) {
            textUser.setText("Enter your username");
            textUser.setForeground(Color.GRAY);
        }
    }

    private void loginButtonMouseEntered(MouseEvent evt) {
        loginLabel.setIcon(setIcon(loginLabel, img2));
    }

    private void loginButtonMouseExited(MouseEvent evt) {
        loginLabel.setIcon(setIcon(loginLabel, img1));
    }

    private void loginButtonMouseClicked(MouseEvent evt) {
        user = textUser.getText().trim();
        pass = textPass.getText().trim();
        loginLabel.setIcon(setIcon(loginLabel, img1));

        //validate if the fields are not empty
        if (user.trim().equals("Enter your username") || pass.equals("000000")) {
            JOptionPane.showMessageDialog(null, "You must fill in all the fields");
        } else if (user.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "You must fill in all the fields");
        } else {
            loginRequestConnection();
        }
    }

    private void loginRequestConnection() {
        try {
            String query = "select id, userName, level from user where user = '" + user + "' and password = '" + pass + "'";

            Connection cn = ConnectionDB.connectionDB();

            PreparedStatement pst = cn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String level = rs.getString("level");

                idUser = rs.getInt("id");
                userName = rs.getString("userName");

                if (level.equalsIgnoreCase("Admin")) {
                    
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new Open();
                        }
                    });
                    dispose();
                    //new Open().setVisible(true);//open the admin interface
                } else if (level.equalsIgnoreCase("Receptionist")) {
                    dispose();
                    new Receptionist().setVisible(true);//open the receptionist interface
                }

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect acces data");
                textUser.setText("");
                textPass.setText("");
            }
        } catch (SQLException e) {
            System.err.println("Login button error: " + e);
        }
    }

}
