class Box<T>{

    T obj;

    public Box(T obj){
        this.obj = obj; 
    }

    T getObj(){
        return obj;
    }
}

class Pair<K,V>{
    K key;
    V value;

    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }

}

public class LearnGenerics {

    public static void main(String[] args){
        // implementing generics

        Pair<Integer, String> ref = new Pair<>(101,"Aditya");
        Pair<String,Integer> ref2 = new Pair<>("Aditya",101);
        
        Box<String> b1 = new Box<>("Cube");
        Box<Integer> b2 = new Box<>(131);

        String t = b1.getObj();
        System.out.println(t);
        
    }
}
