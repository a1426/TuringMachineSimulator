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
    public void actionPerformed(ActionEvent e) {
        String text = txt.getText();
        String[] spl = text.split(",");
        ArrayList<Integer> states=new ArrayList<>();
        for(int i =0; i<spl.length; i++){
            try{
            int a= Integer.parseInt(spl[i]);
            states.add(a);
            }
            catch (NumberFormatException ex){
            }
        }
        //Moves to the next stage
        if(states.size()>0){
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();

        }

    }
}
