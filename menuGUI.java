import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class menuGUI extends JFrame{
    //Helper method for prompting the user to submit some data.
    public static void submit(JFrame f, String prompt, JTextComponent c, ActionListener l){
        f.getContentPane().removeAll();
        f.getContentPane().repaint();
        JLabel states = new JLabel(prompt);
        JButton submit = new JButton("Click this button to submit your answer.");
        submit.addActionListener(l);
        f.add(submit, BorderLayout.SOUTH);
        f.add(c, BorderLayout.CENTER);
        f.add(states, BorderLayout.NORTH);
        f.revalidate();
    }
    //Another helper method, used for splitting
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
            } catch (NumberFormatException ex) {}
        }
        return states;
    }
    //The menu on the upper-left hand.
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
        JMenuItem bb22 = new JMenuItem("Busy Beaver(2 states, 2 symbols)");
        ArrayList<Integer> bb22AL = new ArrayList<>();
        //Creates function for the 2x2 Busy Beaver.
        bb22AL.add(0);
        bb22AL.add(1);
        HashMap<String, String> hm = new HashMap<>();
        for(int state=0; state<=1; state++){
            for(int tape=0; tape<=1; tape++){
                String s = "";
                if(state==0){
                    s+=1+",";
                }
                else if(tape==0) s+=0+",";
                else s+="H,";
                s+=1+",";
                s += ((state + tape) % 2) == 0 ? 1 : -1;

                hm.put(state+","+tape, s);
            }
        }
        bb22.addActionListener(new PDTuringMachineListener(menu, bb22AL,0,0,hm));
        preset.add(bb22);
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
