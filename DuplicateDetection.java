import java.util.*;
public class DuplicateDetection {

    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values");
        int x = 0;
        while(x != -1){
            x = sc.nextInt();
            if(x != -1){
                al.add(x);
            }else{
                break;
            }
        }
        System.out.println("The values entered are: " + al);

        for(int i = 0;i<al.size();i++){
            if(!set.contains(al.get(i))){
                set.add(al.get(i));
            }
        }
        System.out.println("The values after removing duplicates are: " + set);

        //won't work on an unsorted array, so i would try working with set;
        // System.out.println("The values entered are: " + al);
        // //10Arrays.sort(al.toArray(new Integer[0]));
        // for(int i = 0;i<al.size()-1;i++){
        //     if(al.get(i) == al.get(i+1)){
        //         al.remove(i+1);
        //     }
        // }

       // System.out.println("The values after removing duplicates are: " + al);

       
    }
}

