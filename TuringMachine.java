import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TuringMachine {
    //The list of all internal states.
    private List<Integer> stateList;
    //Takes in a mapping of the object state, and the tape state, seperated by a comma. The format is "[state,tape,left or right]", where left = -1, right=1.
    private Map<String,Integer[]> function;
    //The list of states that cause the machine to halt.
    //The tape object.
    private Tape tape;
    private int initial;
    private int index=0;
    public Tape getTape(){
        return tape;
    }
    public int getState(){
        return initial;
    }
    public int getIndex(){
        return index;
    }
    public int maxState(){
        int a=stateList.get(0);
        for(int i=1; i<stateList.size();i++){
            a=Math.max(a,stateList.get(i));
        }
        return a;
    }
    public TuringMachine(List<Integer> sl, HashMap<String,Integer[]> f, int blank, int i){
        stateList=sl;
        function=f;
        tape=new Tape(blank);
        initial=i;
    }
    //Returns whether it has halted.
    public boolean run(){
        //While the state isn't a halt state, it uses the map to determine the new state, written value, and direction.
        Integer[] map=function.get(initial+","+tape.getElement(index));
        initial=map[0];
        tape.setElement(map[1],index);
        //Moves index(i.e. the head of the machine), left or right depending on the function. If it is 2(a halt state), it halts.
        if(index==2) return false;
        index+=map[2];
        return true;

    }
}