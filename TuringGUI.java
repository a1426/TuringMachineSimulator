import javax.swing.*;
import javax.swing.JFrame;

public class TuringGUI {
    private TuringMachine tm;
    private JFrame frame;
    //Cannot be local, to be able to be changed inside the lambda.
    private int count=0;
    public TuringGUI(TuringMachine tm, JFrame f){
        this.tm=tm;
        frame=f;
    }
    public void run(){
        JOptionPane finish = new JOptionPane();
        frame.setSize(1311,300);
        //Credit to StackOverflow for helping me find the Timer class as a way to handle delays without threading issues.
        Timer gui = new Timer(2000,listener->{
            if(tm.run()){
                count++;
                ((Timer)listener.getSource()).stop();
                JOptionPane.showInternalMessageDialog(frame, "information",
                        "information", JOptionPane.INFORMATION_MESSAGE);

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
