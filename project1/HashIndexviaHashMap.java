import java.util.HashMap;
import java.util.ArrayList;

public class HashIndex extends HashMap{

    public HashIndex(){
        super();
    }

    public int find(String ID){
        Integer i = (Integer) this.get(ID);
        if (i == null) return 0;
        return i;
    }
	
    public int set(String ID){
        Integer i = (Integer) this.put(ID);
        if(i == null) return 0;
    }

    public int get(String ID){
        return this.ID;
    }

    public int delete(String ID){
        this.remove(ID);
    }
}
