package mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingCanvas extends JPanel{

    protected Shapes shapes;
    private int chosenShape = 1;
    private int red = 191;
    private int green = 168;
    private int blue = 229;

    DrawingCanvas()
    {
        shapes = new Shapes();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        this.setBackground(Color.lightGray);
        this.setBounds(10,10,965,480);

        shapes.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                shapes.requestFocusInWindow();
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    if (chosenShape == 1)
                        shapes.addCircle(e.getPoint(), new Color(red, green, blue));
                    else
                        shapes.addSquare(e.getPoint(), new Color(red, green, blue));
                }
                repaint();
            }
        });
        shapes.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {
                Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePosition, shapes);

                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_C:
                        if (shapes.contains(mousePosition))
                        {
                            shapes.addCircle(mousePosition, new Color(red, green, blue));
                            repaint();
                        }
                        break;
                    case KeyEvent.VK_S:
                        if (shapes.contains(mousePosition))
                        {
                            shapes.addSquare(mousePosition, new Color(red, green, blue));
                            repaint();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        this.add(shapes, BorderLayout.CENTER);
        this.setVisible(true);
    }


    public void setChosenShape(int whichOne)
    {
        this.chosenShape = whichOne;
    }

    public void setColor(String color, int value)
    {
        switch (color) {
            case "red" -> this.red = value;
            case "green" -> this.green = value;
            case "blue" -> this.blue = value;
        }
    }

}
