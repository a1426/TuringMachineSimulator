import java.util.ArrayList;
import java.util.Arrays;

public class Tape {
    //A tape is made of two
    private ArrayList<Integer> r_tape=new ArrayList<>();
    private ArrayList<Integer> l_tape=new ArrayList<>();
    private int blank;
    public Tape(int blank){
        this.blank=blank;
        r_tape.add(blank);
        l_tape.add(blank);
    }
    //returns a 23 sized array for the GUI.
    public int[] content(int index){
        int[] ans = new int[23];
        for(int i=0; i<12; i++){
            ans[i+11]=getElement(index+i);
        }
        for(int i=-1; i>-12; i--){
            ans[i+11]=getElement(index+i);
        }
        return ans;
    }

    public int getElement(int index){
        //The index will only vary by 1.
        if(index>=r_tape.size()){
            for(int i= r_tape.size(); i<=index+1; i++) r_tape.add(blank);
        }
        else if(index<0&&-index+1>=l_tape.size()){

            for(int i= l_tape.size(); i<=-index+1; i++) l_tape.add(blank);
        }
        if(index>=0){
            return r_tape.get(index);
        }
        else return l_tape.get(-index+1);
    }
    public void setElement(int index, int val){
        System.out.println(Arrays.toString(content(index)));
        //Just to ensure that it exists.
        int i=getElement(index);
        if(index>=0){
            r_tape.set(index,val);
        }
        else l_tape.set(-index+1,val);
        System.out.println(i+" to "+ getElement(index)+val);
        System.out.println(Arrays.toString(content(index))+"\n");
    }
    public String toString(){
        String s= "";
        for(int a: l_tape){
            s=s+a;
        }
        return s;
    }
}
