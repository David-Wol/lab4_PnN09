package login;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try{
                new Window();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
