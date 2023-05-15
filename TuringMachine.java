import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TuringMachine {
    //The list of all internal states.
    private List<Integer> stateList;
    //Takes in a mapping of the object state, and the tape state, seperated by a comma. The format is "[state,tape,left or right]", where left = -1, right=1.
    private Map<String,Integer[]> function;
    //The list of states that cause the machine to halt.
    private List<Integer> haltStates;
    //The blank symbol.
    private int blank;
    //The tape object.
    private Tape tape;
    public TuringMachine( List<Integer> sl, HashMap<String,Integer[]> f, List<Integer> hs, int b){
        stateList=sl;
        function=f;
        haltStates=hs;
        blank=b;
        tape=new Tape(blank);
    }
    public void run(int i){
        int index=0;
        int state=i;
        //While the state isn't a halt state, it uses the map to determine the new state, written value, and direction.
        while(!haltStates.contains(state)){
            Integer[] map=function.get(state+","+tape.getElement(index));
            state=map[0];
            tape.setElement(map[1],index);
            //Moves index(i.e. the head of the machine), left or right depending on the function.
            index+=map[2];
        }
    }
}
