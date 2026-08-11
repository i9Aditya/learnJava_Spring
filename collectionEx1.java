import java.util.*;
public class collectionEx1 {
    public static void main(String[] args){

        HashSet<Integer> hs = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            int x = scanner.nextInt();
            if(x < 0){
                break;
            }

            boolean added = hs.add(x);
            if(!added){
                System.out.println("Duplicate : " + x);
            }
        }   
        scanner.close();
    }
}
