//modified provided ArrayList to work for Member[]

public class ArrayList{
    
    static final int defaultCapacity = 10;
    int capacity;     //max number of elements this can hold
    int currentSize;  //number of elements this is currently holding
    String Member[] array;
    String type;
    String ID;
    String firstName;
    String lastName;

    public ArrayList(){
        capacity = defaultCapacity;
        array = (Member[]) new Object[capacity];
    }

    public ArrayList(int specifiedCapacity){
        capacity = specifiedCapacity;
        array = (Member[]) new Object[capacity];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }
    
    public void setName(int i, Member array){
        array[i] = array;

    public Member get(int i) {
        if (i < currentSize) {
            return(Member) array[i];
        } else{
            return null;
        }
    }
    
    public void add(Member e){
        if(currentSize < capacity){ //space still available
            array[currentSize++] = e;
        } else{
            capacity += defaultCapacity;
            Member[] newArray = (Member[]) new Object[capacity];
            for(int i = 0; i < currentSize; i++){
                newArray[i] = array[i];
            }
            newArray[currentSize++] = e;
            array = newArray;
        }
    }
    
    public void remove(int index) {
        for(int i = index; i < currentSize; i++) {
            array[i] = array[i+1];
        }
        currentSize--;
    }

    public void set(int index, String Member()){
        int i = index;
        array[i] = Member();
    }
    
    public void printAll(){
        System.out.println("Current size = " + currentSize + "/" + capacity);
        for(int i = 0; i < currentSize; i++) {
            System.out.println(array[i].toString());
        }
    }
}
}