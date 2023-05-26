import java.awt.*;

public class TMGraphics extends Canvas {
    private TuringMachine tm;
    public TMGraphics(TuringMachine tm){
        this.tm=tm;
    }
    public void paint(Graphics g) {
        //Draws the head and Squares
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        g.setColor(Color.BLACK);
        g.drawRect(0,100,1311,100);
        for(int i=0; i<=22; i++){
            g.drawLine(57*i,100,57*i,200);
        }
        int s=10;
        int[] xT={(1311-s)/2,1311/2,(1311+s)/2};
        int[] yT={50,60,50};
        g.fillPolygon(xT,yT,3);
        //Fills in the content of the TM in each square.
        int[] c = tm.getTape().content(tm.getIndex());
        for(int i=0; i<23; i++){
            g.drawString(c[i]+"",57*i,155);
        }
        }
}


