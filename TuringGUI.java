import javax.swing.*;
import javax.swing.JFrame;

public class TuringGUI {
    private TuringMachine tm;
    private JFrame frame;
    //The variable cannot be local, so that it may be changed inside the lambda.
    private int count=0;
    public TuringGUI(TuringMachine tm, JFrame f){
        this.tm=tm;
        frame=f;
    }
    public void run(){
        frame.setSize(1311,300);
        //Credit to StackOverflow for helping me find the Timer class as a way to handle delays without threading issues.
        Timer gui = new Timer(1500,listener->{
            count++;
            if(tm.run()){
                ((Timer)listener.getSource()).stop();
                JOptionPane.showMessageDialog(frame, "The Turing Machine has halted after "+count+" iterations.",
                        "Halted!", JOptionPane.INFORMATION_MESSAGE);

            }
            frame.getContentPane().removeAll();
            frame.repaint();
            TMGraphics tmg = new TMGraphics(tm);
            frame.add(tmg);
            frame.revalidate();
        });
        gui.setRepeats(true);
        gui.start();

    }
}
