import javax.swing.*;
import javax.swing.JTextField;
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
        JLabel label=new JLabel("jskfds");
        frame.add(label);
        frame.revalidate();
    }

}
