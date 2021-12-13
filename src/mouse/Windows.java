package mouse;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Windows
{
    private final MakeElement makeElement;

    public Windows()
    {
        makeElement = new MakeElement();
    }

    public void mainWindow()
    {
        JFrame mainWindow = makeElement.makeFrame("Main Window");
        JButton Button1 = makeElement.makeButton("Escaping Button", 300, 100);
        JButton Button2 = makeElement.makeButton("Canvas",300,100);

        Button1.setLocation(150, 300);
        Button1.addActionListener(e -> escapingButtonWindow(mainWindow));
        Button2.setLocation(550, 300);
        Button2.addActionListener(e -> canvasWindow(mainWindow));

        mainWindow.add(Button1);
        mainWindow.add(Button2);
    }

    private void canvasWindow(JFrame oldWindow)
    {
        oldWindow.dispose();

        JFrame canvasWindow = makeElement.makeFrame("Canvas Window");

        DrawingCanvas drawingCanvas = new DrawingCanvas();

        JButton circleButton = makeElement.makeButton("Draw circle", 200,60);
        JButton squareButton = makeElement.makeButton("Draw square",200,60);
        JButton resetButton = makeElement.makeButton("Reset", 200,60);
        JButton returnButton = makeElement.makeButton("Return",200,60);

        JSlider sizeSlider = makeElement.makeSlider(0,400,200);
        JSlider redSlider = makeElement.makeSlider(0,255,191);
        JSlider greenSlider = makeElement.makeSlider(0,255,168);
        JSlider blueSlider = makeElement.makeSlider(0, 255,229);

        JLabel shapeLabel = new JLabel("Current shape: circle");
        JLabel sizeLabel = new JLabel("Size: " + sizeSlider.getValue());
        JLabel redLabel = new JLabel("Red: " + redSlider.getValue());
        JLabel blueLabel = new JLabel("Blue: " + blueSlider.getValue());
        JLabel greenLabel = new JLabel("Green: " + greenSlider.getValue());

        shapeLabel.setBounds(12,550,140,30);
        sizeLabel.setBounds(660,543,70,20);
        redLabel.setBounds(660,593,70,20);
        blueLabel.setBounds(660,643,70,20);
        greenLabel.setBounds(660,693,70,20);

        circleButton.setLocation(10,580);
        circleButton.addActionListener(e -> drawingCanvas.setChosenShape(1));
        circleButton.addActionListener(e -> shapeLabel.setText("Current shape: circle"));

        squareButton.setLocation(10,650);
        squareButton.addActionListener(e -> drawingCanvas.setChosenShape(2));
        squareButton.addActionListener(e -> shapeLabel.setText("Current shape: square"));

        resetButton.setLocation(775,650);
        resetButton.addActionListener(e -> drawingCanvas.shapes.removeShapes());

        returnButton.setLocation(775,580);
        returnButton.addActionListener(e -> returnAction(canvasWindow));

        sizeSlider.setLocation(250,530);
        sizeSlider.addChangeListener(e -> drawingCanvas.shapes.setSize(sizeSlider.getValue()));
        sizeSlider.addChangeListener(e -> sizeLabel.setText("Size: " + sizeSlider.getValue()));

        redSlider.setLocation(250,580);
        redSlider.addChangeListener(e -> redLabel.setText("Red: " + redSlider.getValue()));
        redSlider.addChangeListener(e -> drawingCanvas.setColor("red", redSlider.getValue()));

        greenSlider.setLocation(250,680);
        greenSlider.addChangeListener(e -> greenLabel.setText("Green: " + greenSlider.getValue()));
        greenSlider.addChangeListener(e -> drawingCanvas.setColor("green", greenSlider.getValue()));

        blueSlider.setLocation(250,630);
        blueSlider.addChangeListener(e -> blueLabel.setText("Blue: " + blueSlider.getValue()));
        blueSlider.addChangeListener(e -> drawingCanvas.setColor("blue", blueSlider.getValue()));

        canvasWindow.add(shapeLabel);
        canvasWindow.add(sizeLabel);
        canvasWindow.add(redLabel);
        canvasWindow.add(greenLabel);
        canvasWindow.add(blueLabel);
        canvasWindow.add(sizeSlider);
        canvasWindow.add(redSlider);
        canvasWindow.add(greenSlider);
        canvasWindow.add(blueSlider);
        canvasWindow.add(drawingCanvas);
        canvasWindow.add(circleButton);
        canvasWindow.add(squareButton);
        canvasWindow.add(resetButton);
        canvasWindow.add(returnButton);
    }

    private void escapingButtonWindow(JFrame oldWindow)
    {
        oldWindow.dispose();


        JFrame escapingButtonWindow = makeElement.makeFrame("Running Button Window");
        JButton escapingButton = makeElement.makeButton("Return", 300, 100);

        escapingButton.setLocation(350, 300);
        escapingButton.addActionListener(e -> returnAction(escapingButtonWindow));

        escapingButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                Color color;
                Random random = new Random();

                if(e.getX() > 2)
                    escapingButton.setLocation(random.nextInt(600), random.nextInt(550));
                     color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                     escapingButton.setBackground(color);
            }
        });
        escapingButtonWindow.add(escapingButton);
    }

    private void returnAction(JFrame window)
    {
        window.dispose();
        mainWindow();
    }
}