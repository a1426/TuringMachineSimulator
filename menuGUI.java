import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class menuGUI extends JFrame{
    public static void submit(JFrame f, String d, JTextComponent c, ActionListener l){
        f.getContentPane().removeAll();
        f.getContentPane().repaint();
        JLabel states = new JLabel(d);
        JButton submit = new JButton("Click this button to submit your answer.");
        submit.addActionListener(l);
        f.add(submit, BorderLayout.SOUTH);
        f.add(c, BorderLayout.CENTER);
        f.add(states, BorderLayout.NORTH);
        f.revalidate();
    }
    public static ArrayList<Integer> helper(JTextComponent txt) {
        String text = txt.getText();
        String[] spl = text.split(",");
        ArrayList<Integer> states = new ArrayList<>();
        for (int i = 0; i < spl.length; i++) {
            try {
                int a = Integer.parseInt(spl[i]);
                if (!states.contains(a)) {
                    states.add(a);
                }
            } catch (NumberFormatException ex) {
            }
        }
        return states;
    }
    public menuGUI(){
        super("Turing Machine Simulator");
        JFrame menu = new JFrame();
        menu.setSize(800, 500);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenu mainMenu=new JMenu("Actions");
        JMenuItem custom = new JMenuItem("Create a custom Turing Machine");
        custom.addActionListener(new CreateListener(menu));
        mainMenu.add(custom);
        JMenu preset = new JMenu("Select a preset Turing Machine");
        preset.addActionListener(new EndListener());
        mainMenu.add(preset);
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new EndListener());
        mainMenu.add(exit);
        JLabel welcome = new JLabel("Start with the menu in the upper left hand corner.");
        menu.add(welcome);
        JMenuBar mBar = new JMenuBar();
        mBar.add(mainMenu);
        menu.setJMenuBar(mBar);
        menu.setVisible(true);
    }
    public static void main(String[] args){
        new menuGUI();
    }

}
