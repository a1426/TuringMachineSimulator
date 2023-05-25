import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;

public class TuringCodeListener implements ActionListener {
    JTextComponent txt;
    JFrame frame;
    ArrayList<Integer> states;
    int iState;
    ArrayList<Integer> tapeStates;
    int blank;
    HashMap<String, Integer[]> func;
    public TuringCodeListener(JTextComponent t, JFrame f, ArrayList<Integer> s, int i,ArrayList<Integer> ts, int b,HashMap<String, Integer[]> fc){
        txt=t;
        frame=f;
        states=s;
        iState=i;
        tapeStates=ts;
        blank=b;
        func=fc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text= txt.getText();
        String key="";
        Integer[] arr = new Integer[3];
        String[] rules=text.split("\n");
        for(String s: rules){
            String[] halves=s.split("-");
            if(halves.length!=2) continue;
            if(halves[0].split(",").length!=2||(halves[1].split(",").length!=3&&halves[1].split(",").length!=1)){
                System.out.println("1");
                continue;
            }
            try {
                for (int i = 0; i < 2; i++) {
                    int j = Integer.parseInt(halves[0].split(",")[i]);
                    key += j;
                    if (i == 0) key += ",";
                }
            } catch (NumberFormatException ex) {
                System.out.println("3");
                continue;
            }
            if(halves[1].split(",").length==1&&halves[1].toLowerCase().contains("h")){
                System.out.println(2);
                arr[2]=2;
                System.out.println(arr);
            }
            else {
                try {
                    for (int i = 0; i < 3; i++) {
                        String j = halves[1].split(",")[i];
                        if (i != 2) {
                            arr[i] = Integer.parseInt(j);
                        } else {
                            switch (j.toLowerCase()) {
                                case "0" -> arr[2] = 0;
                                case "l" -> arr[2] = -1;
                                case "r" -> arr[2] = 1;
                                default -> throw new NumberFormatException();
                            }
                        }
                    }

                } catch (NumberFormatException ex) {
                    System.out.println("4");
                    continue;
                }
            }
            //prevents rewriting
            System.out.println(func.containsKey(key));
            System.out.println(func.get(key));
            System.out.println(key);
            if(func.containsKey(key)&&func.get(key)==null){System.out.println("End");
                func.put(key,arr);
            }
            if(!func.containsValue(null)){
                TuringMachine tm = new TuringMachine(states,func,blank,iState);
                TuringGUI tg= new TuringGUI(tm,frame);
                System.out.println("End");
                //run turing machine
            }
            else{
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

