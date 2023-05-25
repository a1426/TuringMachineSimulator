import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class PDTuringMachineListener implements ActionListener {
    private TuringMachine tm;
    private JFrame frame;
    public PDTuringMachineListener(JFrame f, ArrayList<Integer> s, int i, int b, HashMap<String, Integer[]> fc){
        tm=new TuringMachine(s,fc,b,i);
        frame=f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new TuringGUI(tm,frame).run();
    }
}
