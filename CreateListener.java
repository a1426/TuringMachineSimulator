import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CreateListener implements ActionListener{
    private final JFrame frame;
    public CreateListener(JFrame f){
        frame=f;
    }
    //Starts by prompting
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        JTextField area = new JTextField();
        //In hindsight, chaining event listeners wasn't the neatest idea.
        menuGUI.submit(frame,"Enter all of the internal states of the Turing Machine, separated by commas.",area, new StateListener(area, frame));



    }

}
