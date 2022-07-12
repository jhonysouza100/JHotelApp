package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import resources.ConnectionDB;
import resources.JavaHotel;

public class Open extends JavaHotel {
    
    private JLabel date;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextField money;
    private JPanel open;
    private JLabel openLabel;
    private JLabel starting;
    private JTable table;
    private JLabel turn;
    private JLabel username;
    private JLabel wallpaper;
    
    public Open() {
        initParametersOpen();
        setFrameStatebar();
        initComponentsOpen();
        previousFillRowsRequestConnection();
        customerFillTextRequestConnection();
        setSize(440, 240);
        
    }
    
    private void initParametersOpen() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Open");
        setName("JFrame2");
        setUndecorated(true);
        setResizable(false);
        setSize(440, 240);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setVisible(true);
    }
    
    private void initComponentsOpen() {
        
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        starting = new JLabel();
        money = new JTextField();
        turn = new JLabel();
        username = new JLabel();
        date = new JLabel();
        open = new JPanel();
        openLabel = new JLabel();
        wallpaper = new JLabel();
        
        jSeparator1.setBackground(Color.WHITE);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(1, 31, 440, 10);
        
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 400, 90);
        
        starting.setForeground(Color.WHITE);
        starting.setText("CI $");
        getContentPane().add(starting);
        starting.setBounds(20, 50, 30, 16);
        
        money.setBackground(Color.BLACK);
        money.setForeground(Color.WHITE);
        money.setHorizontalAlignment(JTextField.RIGHT);
        money.setText("0.00,00");
        money.setBorder(null);
        getContentPane().add(money);
        money.setBounds(50, 50, 110, 16);
        
        turn.setForeground(Color.WHITE);
        turn.setHorizontalAlignment(SwingConstants.CENTER);
        turn.setText("trun");
        getContentPane().add(turn);
        turn.setBounds(160, 50, 60, 16);
        
        username.setForeground(Color.WHITE);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setText("username");
        getContentPane().add(username);
        username.setBounds(220, 50, 120, 16);
        
        date.setForeground(Color.WHITE);
        date.setHorizontalAlignment(SwingConstants.CENTER);
        date.setText("date");
        getContentPane().add(date);
        date.setBounds(340, 50, 80, 16);
        
        open.setBackground(Color.BLACK);
        open.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        open.setLayout(new BorderLayout(0, 0));
        open.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                openMouseClicked(evt);
            }
        });
        openLabel.setFont(setFont());
        openLabel.setForeground(Color.WHITE);
        openLabel.setHorizontalAlignment(SwingConstants.CENTER);
        openLabel.setText("OPEN");
        open.setBounds(150, 180, 120, 30);
        open.add(openLabel, BorderLayout.CENTER);
        getContentPane().add(open);
        
        wallpaper.setBackground(Color.BLACK);
        wallpaper.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        wallpaper.setOpaque(true);
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 440, 240);
        
        pack();
    }
    
    DefaultTableModel model = new DefaultTableModel();
    
    public void previousFillRowsRequestConnection() {
        String query = "select startingMoney, turn, username, balance from turn where idUser = 1 and idCash=1";
        try {
            Connection cn = ConnectionDB.connectionDB();
            
            PreparedStatement pst = cn.prepareStatement(query);
            
            ResultSet rs = pst.executeQuery();
            
            table = new JTable(model);
            jScrollPane1.setViewportView(table);
            
            model.addColumn("Starting Money");
            model.addColumn("Turn");
            model.addColumn("User");
            model.addColumn("Balance");
            
            while (rs.next()) {
                Object[] row = new Object[4];
                
                for (int i = 0; i < 4; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                
                model.addRow(row);
                
            }
            table.setRowHeight(20);
            table.setEnabled(false);
            table.setBackground(Color.BLACK);
            table.setForeground(Color.WHITE);
            table.getColumnModel().getColumn(0).setPreferredWidth(140);
            table.getColumnModel().getColumn(1).setPreferredWidth(60);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error displaying information" + e);
        }
    }
    
    private void openMouseClicked(java.awt.event.MouseEvent evt) {                                  
        Receptionist receptionist = new Receptionist();
        receptionist.setVisible(true);
        dispose();
    }
    
    public void customerFillTextRequestConnection() {
        try {
            Connection cn = ConnectionDB.connectionDB();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from turn where idUser = '1' and idCash = '1'"
            );
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                money.setText(rs.getString("startingMoney"));
                turn.setText(rs.getString("turn"));
                username.setText(rs.getString("username"));
                date.setText(rs.getString("date"));
                
            }
            
            cn.close();
            
        } catch (SQLException e) {
            System.err.print("Error loading cash: " + e);
        }
    }
}
