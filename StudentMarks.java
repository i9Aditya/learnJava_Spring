import java.util.*;

public class StudentMarks {
    public static void main(String[] args){
        HashMap<String,Integer> studentMarks = new HashMap<String,Integer>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1 for Add Student");
            System.out.println("2 for Search Student");
            System.out.println("3 for Update Student");
            System.out.println("4 for Remove Student");
            System.out.println("5 for Print Student");

            int x = sc.nextInt();

            if(x == 1){
                System.out.print("Enter the name of the student : ");
                String name = sc.next();
                System.out.println();
                System.out.print("Enter the marks of the student : ");
                int marks= sc.nextInt();
                System.out.println();

                studentMarks.put(name,marks);
            }else if(x==2){
                System.out.println("Enter the name of the student : ");
                String name = sc.next();
                if(studentMarks.containsKey(name)){
                    System.out.println(name + " : " + studentMarks.get(name));
                }
                else{
                    System.out.println("Student Does not exit!!");
                }
            }else if(x==3){
                System.out.println("Enter the name of the student : ");
                String name = sc.next();
                System.out.println("Enter the new marks : ");
                Integer marks = sc.nextInt();
                if(studentMarks.containsKey(name)){
                   studentMarks.put(name,marks);
                }
                else{
                    System.out.println("Student Does not exit!!");
                }
                

                System.out.println("Updated entry : " + studentMarks.get(name));
            }else if(x==4){
                System.out.println("Enter the name of the student : ");
                String name = sc.next();
                studentMarks.remove(name);
            }else if(x == 5){
                System.out.println(studentMarks);
            }else if(x==6){
                break;
            }

        }
        sc.close();
    }
}
