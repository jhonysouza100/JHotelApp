package resources;
import interfaces.Login;
import java.awt.EventQueue;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
