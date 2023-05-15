import javax.swing.*;
import java.awt.BorderLayout;
public class menuGUI{
    public static void main(String[] args){
        JFrame menu = new JFrame();
        menu.setSize(1000, 300);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setTitle("Turing Machine Simulator");
        JButton exitButton = new JButton("Click here to exit.");
        exitButton.addActionListener(new EndListener());
        menu.add(exitButton, BorderLayout.EAST);
        JButton createButton = new JButton("Click here to create a new Turing Machine.");
        createButton.addActionListener(new EndListener());
        menu.add(createButton, BorderLayout.WEST);
        JButton presetButton = new JButton("Click here to use a preset Turing Machine.");
        presetButton.addActionListener(new EndListener());
        menu.add(presetButton, BorderLayout.CENTER);
        menu.setVisible(true);
    }
}
