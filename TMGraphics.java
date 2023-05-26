import java.awt.*;
import java.util.Arrays;

public class TMGraphics extends Canvas {
    private TuringMachine tm;
    public TMGraphics(TuringMachine tm){
        this.tm=tm;
    }
    public void paint(Graphics g) {
        int index= tm.getIndex();
        Tape tape = tm.getTape();
        System.out.println(index);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        g.drawRect(0,100,1311,100);
        for(int i=0; i<=22; i++){
            g.drawLine(57*i,100,57*i,200);
        }
        int s=10;
        int[] xT={(1311-s)/2,1311/2,(1311+s)/2};
        int[] yT={50,60,50};
        g.setColor(Color.BLACK);
        g.fillPolygon(xT,yT,3);
        int[] c = tape.content(index);
        for(int i=0; i<23; i++){
            g.drawString(c[i]+"",57*i,155);
        }

        }
}


