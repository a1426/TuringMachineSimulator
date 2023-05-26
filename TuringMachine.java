import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TuringMachine {
    //The list of all internal states.
    private List<Integer> stateList;
    //The key is the object state, and the tape state, separated by a comma. The format is "state,tape,left or right", where left = -1, right=1.
    private Map<String,String> function;
    //The tape object.
    private Tape tape;
    private int initial;
    private int index=0;
    public Tape getTape(){
        return tape;
    }
    public int getIndex(){
        return index;
    }
    public TuringMachine(List<Integer> sl, HashMap<String,String> f, int blank, int i){
        stateList=sl;
        function=f;
        tape=new Tape(blank);
        initial=i;
    }
    //Returns whether it has halted.
    public boolean run(){
        //While the state isn't a halt state, it uses the map to determine the new state, written value, and direction.
        String[] map=function.get(initial+","+tape.getElement(index)).split(",");
        //Writes to the tape, moves, and sees the new state/whether it halted.
        tape.setElement(index,Integer.parseInt(map[1]));
        index+=Integer.parseInt(map[2]);
        if(map[0].equals("H")){
            return true;
        }
        else initial=Integer.parseInt(map[0]);
        return false;
    }
}