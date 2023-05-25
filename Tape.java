import java.util.ArrayList;

public class Tape {
    //A tape is made of two
    private ArrayList<Integer> r_tape=new ArrayList<>();
    private ArrayList<Integer> l_tape=new ArrayList<>();
    private int blank;
    public Tape(int blank){
        this.blank=blank;
        r_tape.add(blank);
    }
    public int length(){
        return r_tape.size()+l_tape.size();
    }
    public int getElement(int index){
        //The index will only vary by 1.
        if(index>=r_tape.size()){
            r_tape.add(blank);
        }
        else if(index<0&&-index>=l_tape.size()){
            l_tape.add(blank);
        }
        if(index>=0){
            return r_tape.get(index);
        }
        else return l_tape.get(-index);
    }
    public void setElement(int index, int val){
        //Just to ensure that it exists.
        getElement(index);
        if(index>=0){
            r_tape.set(index,val);
        }
        else l_tape.set(-index,val);

    }
}
