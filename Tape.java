import java.util.ArrayList;

public class Tape {
    //A tape is made of two ArrayLists, as it must be ever-expanding in two directions.
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
        //goes back to front so as to not
        for(int i=-1; i>-12; i--){
            ans[i+11]=getElement(index+i);
        }
        return ans;
    }

    public int getElement(int index){
        //If one attempts to access a not defined element, enough blank elements are added such that it is defined.
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
        //This call ensures that the element exists.
        getElement(index);
        if(index>=0){
            r_tape.set(index,val);
        }
        else l_tape.set(-index+1,val);
    }

}
