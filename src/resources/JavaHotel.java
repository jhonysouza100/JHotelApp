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

    private JPanel topBar;
    private JLabel exitButtonText;
    private JLabel exitButtonLabel;
    private JPanel exitButton;
    private JLabel minButtonText;
    private JPanel minButton;
    private JLabel minButtonLabel;
    private int Xmouse, Ymouse;
    
    public JavaHotel(){
        //set default icon for all frame
       setIconImage(getIconImage());
    }
    
    //set the wallpaper
    public static void setWallpaper(JLabel label) {
        ImageIcon image = new ImageIcon("src/images/wallpaper.jpeg");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }
    
    ////to set an image
    public static void setImage(JLabel label, String img) {
        ImageIcon image = new ImageIcon("src/images/"+img);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }
    
    //to set a icon image in elements
    public Icon setIcon(JLabel label, String img){
        ImageIcon image = new ImageIcon("src/images/"+img);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return icon;
 
    }
    
    //catch a icon image object
    @Override 
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;

    }
   
    //set a icon image object
    @Override
    public void setIconImage(Image image) {
        super.setIconImage(image);
    }
    
    //set default Color RGB teme
    public static Color painBakground(){
    //set default Font style teme
        Color color = new Color(174,204,50);
        return color;
    } 
    
    public static Font setFont(){
       Font f = new Font("Roboto", 0, 12);
       return f;
    }
    
    //set bounds inside container
    public void setBoundsInside(JLabel label, JPanel container) {
        label.setSize(container.getSize().width, container.getSize().height);
    }
    
    //resize button method (panel, label, intResize, img)
    public void resizeButton(JPanel panel, JLabel label, int resize, String img){
        int x=panel.getX()-(resize/2);//reposition x
        int y=panel.getY()-(resize/2);// reposition y
        int width=panel.getSize().width+resize;//new size width
        int height=panel.getSize().height+resize;//new height
        panel.setBounds(x,y,width,height);
        
        label.setSize(panel.getSize().width, panel.getSize().height);
        setImage(label, img);
    }
    
    //get frame width minus borders
    private int getFrameWidth(){
        int x= getSize().width - 2;
        return x;    
    }
    
    //build top bar decoration for all frame
    public void buildTopBarDecor() {
        topBar = new JPanel();
        exitButton = new JPanel();
        exitButtonText = new JLabel();
        exitButtonLabel = new JLabel();
        minButton = new JPanel();
        minButtonText =new JLabel();
        minButtonLabel = new JLabel();
        
        topBar.setBounds(1, 1, getFrameWidth(), 30);
        topBar.setOpaque(false);
        topBar.setLayout(null);
        topBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                topBarMousePressed(evt);
            }
        });
        topBar.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                topBarMouseDragged(evt);
            }
        });

        exitButton.setBounds(5, 5, 17, 17);
        exitButton.setOpaque(false);
        exitButton.setLayout(new BorderLayout(0,0));
        exitButton.addMouseListener(new MouseAdapter() {
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

        exitButtonText.setFont(new Font("Roboto Black", 0, 15));
        exitButtonText.setHorizontalAlignment(SwingConstants.CENTER);
        setBoundsInside(exitButtonText, exitButton);
        
        setBoundsInside(exitButtonLabel, exitButton);
        setImage(exitButtonLabel, "btnRed.png");
        
        exitButton.add(exitButtonText, BorderLayout.CENTER);
        exitButton.add(exitButtonLabel, BorderLayout.CENTER);
        
        minButton.setBounds(29, 5, 17, 17);
        minButton.setOpaque(false);
        minButton.setLayout(new BorderLayout(0,0));
        minButton.addMouseListener(new MouseAdapter() {
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
        
        minButtonText.setFont(new Font("Roboto Black", 0, 24));
        minButtonText.setHorizontalAlignment(SwingConstants.CENTER);
        setBoundsInside(minButtonText, minButton);
        
        setBoundsInside(minButtonLabel, minButton);
        setImage(minButtonLabel, "btnGreen.png");
        
        minButton.add(minButtonText, BorderLayout.CENTER);
        minButton.add(minButtonLabel, BorderLayout.CENTER);

        topBar.add(exitButton);
        topBar.add(minButton);        
        getContentPane().add(topBar);   
    }
    
    //sets the window movement
    private void topBarMousePressed(MouseEvent evt) {
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }
    
    private void topBarMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - Xmouse, y - Ymouse);
    }
    
    //set button functionality
    private void exitPanelMouseClicked(MouseEvent evt) {
        System.exit(0);
    }
    private void exitPanelMouseEntered(MouseEvent evt) {
        resizeButton(exitButton, exitButtonLabel, 2, "btnRedPressed.png");
        exitButtonText.setSize(exitButton.getSize().width,exitButton.getSize().height);
        exitButtonText.setText("x");   
    }
    private void exitPanelMouseExited(MouseEvent evt) {
        resizeButton(exitButton, exitButtonLabel, -2, "btnRed.png");
        exitButtonText.setText("");
    }
    private void minimizePanelMouseClicked(MouseEvent evt) {
        setExtendedState(ICONIFIED);
    }
    private void minimizePanelMouseEntered(MouseEvent evt) {
        resizeButton(minButton, minButtonLabel, 2, "btnGreenPressed.png");
        minButtonText.setSize(minButton.getSize().width,minButton.getSize().height);
        minButtonText.setText("-");
    }
    private void minimizePanelMouseExited(MouseEvent evt) {
        resizeButton(minButton, minButtonLabel, -2, "btnGreen.png");
        minButtonText.setText("");
    }
}
