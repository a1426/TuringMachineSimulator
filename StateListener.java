import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StateListener implements ActionListener{
    JTextComponent txt;
    JFrame frame;
    public StateListener(JTextComponent t, JFrame f){
        txt=t;
        frame=f;
    }
    @Override
    //Listens for the list of internal states, then sets up the phase asking for the initial state.
    public void actionPerformed(ActionEvent e) {
        ArrayList<Integer> states=menuGUI.helper(txt);
        if(states.size()>0){
            JTextField area = new JTextField();
            menuGUI.submit(frame,"Enter the initial state of the Turing Machine, from the following: "+states,area, new InitialStateListener(area, frame, states));
        }
    }
}
