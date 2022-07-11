package resources;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Source extends JFrame {

    private JPanel statusbar;
    private JLabel exitLabel;
    private JPanel exitPanel;
    private JPanel minimizePanel;
    private JLabel minimizeLabel;
    private int Xmouse, Ymouse;
    public Source(){
       setIconImage(getIconImage());

    }
    
    public static void setWallpaper(JLabel label) {
        ImageIcon image = new ImageIcon("src/images/wallpaper.jpeg");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }
    
    public Icon addImage(JLabel label, String img){
        ImageIcon image = new ImageIcon("src/images/"+img);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return icon;
 
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;

    }
   
    @Override
    public void setIconImage(Image image) {
        super.setIconImage(image);
    }
    
    public static Color painBakground(){
        Color color = new Color(174,204,50);
        return color;
    } 
    
    public static Font setFont(){
       Font f = new Font("Roboto", 0, 12);
       return f;
    }
    
    private int getFrameWidth(){
        int x= getSize().width - 2;
        return x;
        
    }
    public void setFrameStatebar() {
        statusbar = new JPanel();
        exitPanel = new JPanel();
        exitLabel = new JLabel();
        minimizePanel = new JPanel();
        minimizeLabel = new JLabel();
        statusbar.setBackground(new Color(0, 0, 0));
        statusbar.setOpaque(false);
        statusbar.setLayout(null);
        statusbar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                statebarMousePressed(evt);
            }
        });
        statusbar.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                statebarMouseDragged(evt);
            }
        });

        exitPanel.setBackground(Color.BLACK);
        exitPanel.setLayout(new BorderLayout(1, 1));
        exitPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                exitPanelMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                exitPanelMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                exitPanelMouseExited(evt);
            }
        });

        exitLabel.setForeground(Color.WHITE);
        exitLabel.setFont(new Font("Roboto", 1, 24));
        exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        exitLabel.setText("X");
        exitPanel.add(exitLabel, BorderLayout.CENTER);

        statusbar.add(exitPanel);
        exitPanel.setBounds(0, 0, 30, 30);
        
        
        minimizePanel.setBackground(Color.BLACK);
        minimizePanel.setLayout(new BorderLayout(1, 1));
        minimizePanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                minimizePanelMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                minimizePanelMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                minimizePanelMouseExited(evt);
            }
        });

        minimizeLabel.setForeground(Color.WHITE);
        minimizeLabel.setFont(new Font("Roboto", 1, 24));
        minimizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minimizeLabel.setText("-");
        minimizePanel.add(minimizeLabel, BorderLayout.CENTER);

        statusbar.add(minimizePanel);
        minimizePanel.setBounds(30, 0, 30, 30);
        
        statusbar.setBounds(1, 1, getFrameWidth(), 30);
        getContentPane().add(statusbar);
        
        
    }
    private void statebarMousePressed(MouseEvent evt) {
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }
    private void statebarMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - Xmouse, y - Ymouse);
    }
    private void exitPanelMouseClicked(MouseEvent evt) {
        System.exit(0);
    }
    private void exitPanelMouseEntered(MouseEvent evt) {
        exitPanel.setBackground(Color.RED);
        exitLabel.setForeground(Color.BLACK);
    }
    private void exitPanelMouseExited(MouseEvent evt) {
        exitPanel.setBackground(Color.BLACK);
        exitLabel.setForeground(Color.WHITE);
    }
    private void minimizePanelMouseClicked(MouseEvent evt) {
        setExtendedState(ICONIFIED);
    }
    private void minimizePanelMouseEntered(MouseEvent evt) {
        minimizePanel.setBackground(Color.RED);
        minimizeLabel.setForeground(Color.BLACK);
    }
    private void minimizePanelMouseExited(MouseEvent evt) {
        minimizePanel.setBackground(Color.BLACK);
        minimizeLabel.setForeground(Color.WHITE);
    }
}
