import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JFrame;

public class TuringGUI {
    private TuringMachine tm;
    private JFrame frame;
    public TuringGUI(TuringMachine tm, JFrame f){
        this.tm=tm;
        frame=f;
    }

    public void run(){
        frame.setSize(1311,300);
        Timer gui = new Timer(1000,listener->{
            if(tm.run()){
                ((Timer)listener.getSource()).stop();
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
