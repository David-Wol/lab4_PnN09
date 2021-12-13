package mouse;

import javax.swing.*;

import static java.awt.Color.white;

public class MakeElement {

    public JFrame makeFrame(String text)
    {
        JFrame frame = new JFrame(text);
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(white);
        frame.setVisible(true);

        return frame;
    }

    public JSlider makeSlider(int min, int max, int def)
    {
        JSlider slider = new JSlider(min, max, def);
        slider.setFocusable(false);
        slider.setSize(400,50);

        return slider;
    }

    public JButton makeButton(String text, int width, int height)
    {
        JButton button = new JButton(text);
        button.setSize(width, height);
        button.setFocusable(false);

        return button;
    }


}
