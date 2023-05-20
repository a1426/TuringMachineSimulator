import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TapeStateListener implements ActionListener {
    JTextComponent txt;
    JFrame frame;
    ArrayList<Integer> states;
    int iState;
    public TapeStateListener(JTextComponent t, JFrame f, ArrayList<Integer> s, int i){
        txt=t;
        frame=f;
        states=s;
        iState=i;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Integer> tapeStates=menuGUI.helper(txt);
        //Moves to the next stage, looking for the initial state
        if(states.size()>0){
            JTextField area = new JTextField();
            menuGUI.submit(frame,"Enter the blank state of the Turing Machine, from the following: "+tapeStates,area, new BlankTapeListener(area, frame, states,iState,tapeStates));
        }

    }

        //Moves to the next stage, looking for the initial state


    }

