import javax.swing.*;
import java.awt.BorderLayout;
public class menuGUI extends JFrame{
    public void menuGUI(){
        JFrame menu = new JFrame();
        menu.setSize(300, 300);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setTitle("Turing Machine Simulator");
        setLayout(new BorderLayout());
        JButton exitButton = new JButton("Click here to exit.");
        exitButton.addActionListener(new EndListener());
        menu.add(exitButton, BorderLayout.EAST);
        JButton exitButton2 = new JButton("Click here to exit.");
        exitButton2.addActionListener(new EndListener());
        menu.add(exitButton2, BorderLayout.CENTER);
        JButton exitButton3 = new JButton("Click here to exit.");
        exitButton3.addActionListener(new EndListener());
        menu.add(exitButton3, BorderLayout.WEST);
        setVisible(true);


    }

}
