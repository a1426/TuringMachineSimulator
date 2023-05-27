import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
public class BlankTapeListener implements ActionListener {
    final JTextComponent txt;
    final JFrame frame;
    final ArrayList<Integer> states;
    final int iState;
    ArrayList<Integer> tapeStates;
    //Listens for the state used on blank tapes, and prompts for the function.
    //This function is also used in Turing Code Listener, hence why it is not just a local variable.
    public static String getPrompt(){
        //Swing uses HTML to format things, so each <br> tag serves as a newline.
        String prompt="<html>On each line, write the rules for how the Turing machine should act.<br>";
        prompt+="Each line should be of the format: Input internal state, Input tape state-Output internal state, Output tape state, direction to move(L=left, R=Right, 0=Don't move)";
        prompt+="For example, 12,33-1,4,L to represent a Turing Machine that,<br>";
        prompt+="when the state is 12 and the tape reads 33, changes the state to 1 and the tape to 4, and then moves left.<br>";
        prompt+="If you wish a state to halt, express it as : 1,2-H, Output, Left/Right.";
        prompt+="All possible combinations of input have been lined out already, all you need to do is to associate an output with each one";
        return prompt;
    }
    public BlankTapeListener(JTextComponent t, JFrame f, ArrayList<Integer> s, int i, ArrayList<Integer> ts){
        txt=t;
        frame=f;
        states=s;
        iState=i;
        tapeStates=ts;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
         HashMap<String, String> func = new HashMap<>();

         String textGuide = "";
         //Defines all possible state-tape input pairs, and puts them in the text field.
         for(int state: states){
             for(int tapeState: tapeStates){
                 textGuide+=state+","+tapeState+"-\n";
                 func.put(state+","+tapeState, null);
             }
         }
         String text = txt.getText();
         int i;
         try{
            if(text!=null) {
                i = Integer.parseInt(text);
                if (tapeStates.contains(i)) {
                    JTextArea area = new JTextArea(textGuide);
                    menuGUI.submit(frame, getPrompt(), area, new TuringCodeListener(area, frame, states, iState, tapeStates, i, func));
                }
            }
        }
        catch (NumberFormatException ex){}
    }
}
