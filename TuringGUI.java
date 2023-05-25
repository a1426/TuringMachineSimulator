import javax.swing.*;
import java.awt.*;

public class TuringGUI {
    private TuringMachine tm;
    private JFrame frame;
    public TuringGUI(TuringMachine tm, JFrame f){
        this.tm=tm;
        frame=f;
    }

    private void drawTape(JFrame f){

    }
    public void run(){


        Timer gui = new Timer(500,listener->{
            if(tm.run()){((Timer)listener.getSource()).stop();}
            //TMGraphics tmg = new TMGraphics();
            //frame.add(tmg);

        });
        gui.setRepeats(true);
        gui.start();

    }
}
