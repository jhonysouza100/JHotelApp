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

public class JavaHotel extends JFrame {

    private JPanel statusbar;
    private JLabel exitButtonText;
    private JLabel exitButtonLabel;
    private JPanel exitPanel;
    private JLabel minimizeButtonText;
    private JPanel minimizePanel;
    private JLabel minimizeButtonLabel;
    private int Xmouse, Ymouse;
    public JavaHotel(){
       setIconImage(getIconImage());

    }
    
    public static void setWallpaper(JLabel label) {
        ImageIcon image = new ImageIcon("src/images/wallpaper.jpeg");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }
    
    public static void setImage(JLabel label, String img) {
        ImageIcon image = new ImageIcon("src/images/"+img);
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
        exitButtonText = new JLabel();
        exitButtonLabel = new JLabel();
        minimizePanel = new JPanel();
        minimizeButtonText =new JLabel();
        minimizeButtonLabel = new JLabel();
        
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

        exitPanel.setOpaque(false);
        exitPanel.setLayout(null);
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
        
        exitPanel.add(exitButtonText);
        exitButtonText.setBounds(0, 0, 17, 17);
        exitPanel.add(exitButtonLabel);
        exitButtonLabel.setBounds(0, 0, 17, 17);

        statusbar.add(exitPanel);
        exitPanel.setBounds(5, 5, 17, 17);
        
        minimizePanel.setOpaque(false);
        minimizePanel.setLayout(null);
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
        
        minimizePanel.add(minimizeButtonText);
        minimizeButtonText.setBounds(0, 0, 17, 17);
        
        minimizePanel.add(minimizeButtonLabel);
        minimizeButtonLabel.setBounds(0, 0, 17, 17);

        statusbar.add(minimizePanel);
        minimizePanel.setBounds(28, 5, 17, 17);
        
        getContentPane().add(statusbar);
        statusbar.setBounds(1, 1, getFrameWidth(), 30);
        
        
        setImage(exitButtonLabel, "btnRed.png");
        setImage(minimizeButtonLabel, "btnGreen.png");
        
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
        exitButtonText.setFont(new Font("Roboto Black", 0, 14));
        exitButtonText.setHorizontalAlignment(SwingConstants.CENTER);
        exitButtonText.setText("x");
        setImage(exitButtonLabel, "btnRedPressed.png");
    }
    private void exitPanelMouseExited(MouseEvent evt) {
        exitButtonText.setText("");
        setImage(exitButtonLabel, "btnRed.png");
    }
    private void minimizePanelMouseClicked(MouseEvent evt) {
        setExtendedState(ICONIFIED);
    }
    private void minimizePanelMouseEntered(MouseEvent evt) {
        minimizeButtonText.setFont(new Font("Roboto Black", 0, 24));
        minimizeButtonText.setHorizontalAlignment(SwingConstants.CENTER);
        minimizeButtonText.setText("-");
        setImage(minimizeButtonLabel, "btnGreenPressed.png");
    }
    private void minimizePanelMouseExited(MouseEvent evt) {
        minimizeButtonText.setText("");
        setImage(minimizeButtonLabel, "btnGreen.png");
    }
}
