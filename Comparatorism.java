import java.util.*;

class Employee{
    String name;
    Double salary;
    Integer age;

    Employee(String name,Double salary, Integer age){
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.salary.compareTo(e2.salary);
    }
}

class AgeComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.age, e2.age);
    }
}
class StringComparator implements Comparator<Employee>{
    public int compare(Employee e1, Employee e2){
        return e1.name.compareTo(e2.name);
    }
}

 public class Comparatorism{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while(true){
            System.out.println("to Add Employee, enter name, salary and age one by one");
            String name = sc.next();
            Double salary = sc.nextDouble();
            Integer age = sc.nextInt();
            Employee e = new Employee(name,salary,age);
            employees.add(e);

           
            System.out.println(employees);
            Collections.sort(employees,new AgeComparator());
            System.out.println(employees);

            System.out.println("Do you want to continue is yes press 0 else press -1");
            int check = sc.nextInt();
            if(check == -1){
                break;
            }
        }
        sc.close();
        
    }
}
