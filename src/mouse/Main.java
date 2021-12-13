package mouse;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try{
                Windows event = new Windows();
                event.mainWindow();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}