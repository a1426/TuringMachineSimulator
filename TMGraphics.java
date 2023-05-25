import javax.swing.*;
import java.awt.*;

public class TMGraphics extends Canvas {
    private final int maxLength;
    private final int pixSize;
    private TuringMachine tm;
    private JFrame f;
    private Graphics g;
    public TMGraphics(Graphics g, JFrame f, TuringMachine tm){
        this.tm=tm;
        this.f=f;
        this.g=g;
        f.add(new ScrollPane(), BorderLayout.CENTER);
        maxLength=(""+tm.maxState()).length();
        pixSize=maxLength*8;
    }
    public void paint(){
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        int w=f.getWidth();
        int maxSquares=w/pixSize;
        Tape tape=tm.getTape();
        int len=tape.length();
        //if()




    }
}
