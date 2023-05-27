import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class TuringCodeListener implements ActionListener {
    JTextComponent txt;
    JFrame frame;
    ArrayList<Integer> states;
    int iState;
    ArrayList<Integer> tapeStates;
    int blank;
    HashMap<String, String> func;
    public TuringCodeListener(JTextComponent t, JFrame f, ArrayList<Integer> s, int i,ArrayList<Integer> ts, int b,HashMap<String, String> fc){
        txt=t;
        frame=f;
        states=s;
        iState=i;
        tapeStates=ts;
        blank=b;
        func=fc;
    }
    //Checks for the function.
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] rules=txt.getText().split("\n");
        //Checks to make sure the user's input is formatted correctly.
        for(String s: rules){
            String key="";
            String[] arr = new String[3];
            String[] halves=s.split("-");
            if(halves.length!=2) continue;
            if(halves[0].split(",").length!=2||(halves[1].split(",").length!=3)){
                continue;
            }
            try {
                for (int i = 0; i < 2; i++) {
                    int j = Integer.parseInt(halves[0].split(",")[i]);
                    key += j;
                    if (i == 0) key += ",";
                }
            } catch (NumberFormatException ex) {
                continue;
            }
            if(halves[1].toLowerCase().contains("h")){
                arr[0]="H";
            }
            else{
                try{
                    arr[0]=""+Integer.parseInt(halves[1].split(",")[0]);
                }
                catch (NumberFormatException exe) {continue;}
            }
            try {
                for (int i = 1; i < 3; i++) {
                    String j = halves[1].split(",")[i];
                    if (i == 1) {
                        arr[i] = ""+Integer.parseInt(j);
                    } else {
                        switch (j.toLowerCase()) {
                            case "0" -> arr[2] = "0";
                            case "l" -> arr[2] = "-1";
                            case "r" -> arr[2] = "1";
                            default -> throw new NumberFormatException();
                        }
                    }
                }

            } catch (NumberFormatException ex) {
                continue;
            }

            System.out.println(s+key);
            //Saves the input and prevents rewriting.
            if(func.containsKey(key)&&func.get(key)==null){
                func.put(key,String.join(",",arr));
            }

            if(!func.containsValue(null)){
                //Starts the GUI
                System.out.println(func);
                TuringMachine tm = new TuringMachine(states,func,blank,iState);
                TuringGUI tg= new TuringGUI(tm,frame);
                tg.run();

            }
            else{
                //If there are unresolved mappings, display those in the text field
                String textGuide="";
                for(int state: states){
                    for(int tapeState: tapeStates){
                        if(func.get(state+","+tapeState)==null)
                            textGuide+=state+","+tapeState+"-\n";
                    }
                }
                JTextArea area = new JTextArea(textGuide);
                menuGUI.submit(frame, BlankTapeListener.getPrompt(), area, new TuringCodeListener(area, frame, states, iState, tapeStates, blank, func));
            }
        }
    }

}

