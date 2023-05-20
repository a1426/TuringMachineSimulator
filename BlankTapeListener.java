import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BlankTapeListener implements ActionListener {
    JTextComponent txt;
    JFrame frame;
    ArrayList<Integer> states;
    int iState;
    ArrayList<Integer> tapeStates;
    public BlankTapeListener(JTextComponent t, JFrame f, ArrayList<Integer> s, int i, ArrayList<Integer> ts){
        txt=t;
        frame=f;
        states=s;
        iState=i;
        tapeStates=ts;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         //One needs to use HTML to format the label
         String lt="<html>Enter the rules for the Turing machine.<br>";
         lt+="On each line, write:";
         lt+="input state,input tape reading,output state, output tape symbol, and either L(eft)/0(no movement)/R(right)<br>";
         lt+="For example, 12,33,1,4,L to represent a Turing Machine that:<br>";
         lt+="When the state is 12 and the tape reads 33, and changes the state to 1 and the tape to 4, then moves left<br>";

        String text = txt.getText();
        int i;
        try{
            if(text!=null) {
                i = Integer.parseInt(text);
                if (states.contains(i)) {
                    JTextField area = new JTextField();
                    menuGUI.submit(frame, lt, area, new TapeStateListener(area, frame, states, i));
                }
            }

        }
        catch (NumberFormatException ex){

        }

        //Moves to the next stage, looking for the initial state


    }
}
