import java.util.Scanner;

public class collectionex2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int largest = -1;
        int secondLargest = -1;

    while(true){

        int x = scanner.nextInt();
        if(x<0){
            break;
        }

        if(x > largest){
            secondLargest = largest;
            largest = x;

        }else if(x>secondLargest && x < largest){
            secondLargest = x;
        }
        

    }
    System.out.println("Second Largest Element : " + secondLargest);
    scanner.close();
    }
}
