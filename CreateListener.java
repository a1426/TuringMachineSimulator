import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CreateListener implements ActionListener{
    private JFrame frame;
    public CreateListener(JFrame f){
        frame=f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        JTextField area = new JTextField();
        /**
        //One needs to use HTML to format the label
        String lt="<html>Enter the rules for the Turing machine.<br>";
        String lt2="On each line, write:<br>";
        String lt3="input state,input tape reading,output state, output tape symbol, and either L(eft)/0(no movement)/R(right)<br>";
        String lt4 = "For example, 12,33,1,4,L to represent a Turing Machine that:<br>";
         String lt5 = "When the state is 12 and the tape reads 33, and changes the state to 1 and the tape to 4, then moves left<br>";JLabel l = new JLabel(lt+lt2+lt3+lt4+lt5+"</html>");
         **/
        JLabel states = new JLabel("Enter all of the internal states of the Turing Machine, separated by commas.");
        JButton submit = new JButton("Click this button to submit your answer.");
        StateListener sl= new StateListener(area, frame);
        submit.addActionListener(sl);
        frame.add(submit,BorderLayout.SOUTH);
        frame.add(area, BorderLayout.CENTER);
        frame.add(states, BorderLayout.NORTH);

        frame.revalidate();
    }

}
