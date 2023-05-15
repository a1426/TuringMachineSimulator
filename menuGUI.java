import javax.swing.*;
public class menuGUI extends JFrame{
    public menuGUI(){
        super("Turing Machine Simulator");
        JFrame menu = new JFrame();
        menu.setSize(300, 300);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenu mainMenu=new JMenu("Actions");
        JMenuItem custom = new JMenuItem("Create a custom Turing Machine");
        CreateListener cl= new CreateListener(menu);
        custom.addActionListener(cl);
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
