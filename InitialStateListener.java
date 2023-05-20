import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InitialStateListener implements ActionListener {
    JTextComponent txt;
    JFrame frame;
    ArrayList<Integer> states;
    public InitialStateListener(JTextComponent t, JFrame f, ArrayList<Integer> s){
        txt=t;
        frame=f;
        states=s;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = txt.getText();
        int i;
        try{
            if(text!=null) {
                i = Integer.parseInt(text);
                if (states.contains(i)) {
                    JTextField area = new JTextField();
                    menuGUI.submit(frame, "Enter a list of all the integers that can be written onto the tape", area, new TapeStateListener(area, frame, states, i));
                }
            }

        }
        catch (NumberFormatException ex){

        }

        //Moves to the next stage, looking for the initial state


    }
}
