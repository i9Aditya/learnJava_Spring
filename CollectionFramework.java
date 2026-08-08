import java.util.*;

public class CollectionFramework {

    //learning the collection framework in java through implementation 
    //ArrayList

    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<String>(10);
    //adding elements to the array list    
    //System.out.println("Initial size of al: " + al.size());
    al.add("Aditya");
    al.add("Navya");
    al.add("Neetu");
    al.add("Yogesh");
    al.add("Rohit");

    //System.out.println("Size of al after insertion : " + al.size());

     //deleting elements from the array list
    al.remove("Rohit");
    //System.out.println("Size of al after deletion : " + al.size());
    
    //printing the array list
    //System.out.println("Contents of al: " + al);

        //ArrayList to Array conversion
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(1);
        al1.add(2);
        al1.add(3);
        Integer[] arr  = new Integer[(al1.size())];
        arr = al1.toArray(arr);

        //printing the array
       // System.out.println("Contents of arr(Object reference convertedd to String): " + arr);
        //To print the array we can use the Arrays.toString() method, to avoid printing the reference of the array, which is printing because array cant override the toString() method, 
        // so it prints the reference of the array, so we can use the Arrays.toString() method to print the contents of the array.
        //System.out.println("Contents of arr(Array's content coverted to String): " + Arrays.toString(arr));


        //Onto LinkedList Class
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");

        ll.addFirst("A");
        ll.addLast("Z");

        System.out.println("Contents of ll: " + ll);

        ll.add(1, "A2");
        System.out.println("Contents of ll after adding A2 at index 1: " + ll);










    }


}
