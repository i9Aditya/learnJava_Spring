import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Member{
    Integer ID;
    String Name;
    HashSet<Book> IssuedBook = new HashSet<>();

    public Member(Integer i, String name){
        ID = i;
        Name = name;
    }
}

class Book{
    Integer ID;
    String Author;
    boolean Availabilty = true;
    String Title;

    public Book(Integer Id, String Author, String Title){
        this.ID = Id;
        this.Author = Author;
        this.Availabilty = true;
        this.Title = Title;

    }
    public Book(Integer Id, String Author, boolean Availability,String Title){
        this.ID = Id;
        this.Author = Author;
        this.Availabilty = Availability;
        this.Title = Title;

    }

    public String toString(){
        return "Book id : "+  this.ID + ", Author : " + this.Author +
        ", Availability : " + Availabilty + ", Title : " + Title;
    }
}

class Library{
ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> Members = new ArrayList<>();
    HashMap<Integer,Book> BookMap = new HashMap<>();
    HashMap<Integer,Member> MemberMap = new HashMap<>();

    void addBook(Integer Id,String Author,boolean Availabilty,String Title){
        if(!BookMap.containsKey(Id)){
          Book b = new Book(Id,Author,Availabilty,Title);   
         books.add(b); 
         BookMap.put(Id, b);
         System.out.println("Book Added");  
        }else{
            System.out.println("Book already exist");
        }
        
    }
    void registerMember(Integer Id,String Name){
        if(!MemberMap.containsKey(Id)){
            Member m = new Member(Id, Name);
            Members.add(m);
            MemberMap.put(Id,m);
            System.out.println("Member Added! ");
        }else{
            System.out.println("Member Already exists -> try again. ");
        }
        
    }
    void removeBook(Integer Id){

        
        if(BookMap.containsKey(Id)){
            if (BookMap.get(Id).Availabilty == false) {
            System.out.println("Books Cannot be removed as it is issued !!");
            return;
            }
            books.remove(BookMap.get(Id));
            BookMap.remove(Id);
        }else{
            System.out.println("Book Doesn't Exist in the Library");
        }
    }
    void issueBook(Integer bID,Integer mID){
        if(BookMap.containsKey(bID) && MemberMap.containsKey(mID)){
            if(BookMap.get(bID).Availabilty == true){
           MemberMap.get(mID).IssuedBook.add(BookMap.get(bID));
           BookMap.get(bID).Availabilty = false;
            System.out.println("Book Issued to : " + MemberMap.get(mID).Name); 
        }else{
            System.out.println("Book not available");
        }
        }else{
            System.out.println("Books or Member Doesn't exist, try again");
        }
        
    }
    void returnBook(Integer m, Integer b){
        // if(BookMap.containsKey(b) && MemberMap.containsKey(m)){
        //     if(MemberMap.get(m).IssuedBook.contains(BookMap.get(b))){
        //     MemberMap.get(m).IssuedBook.remove(BookMap.get(b));
        //     BookMap.get(b).Availabilty = true;
        // }
        // }else if(MemberMap.get(m).IssuedBook.contains(BookMap.get(b))){
        //     System.out.println("Member Does not contain the book!");
        // }
        // else{
        //     System.out.println("Book or member does not exist.");
        // }
        if(BookMap.containsKey(b)){
            if(MemberMap.containsKey(m)){
                if(MemberMap.get(m).IssuedBook.contains(BookMap.get(b))){
                    MemberMap.get(m).IssuedBook.remove(BookMap.get(b));
                    BookMap.get(b).Availabilty = true;
                }else{
            System.out.println("Member Doesn't Issued the book");

                }
            }else{
            System.out.println("Member Doesn't Exist");

            }
        }else{
            System.out.println("Book Doesn't Exist");
        }
        
    }
    Book findBook(Integer Id){
        if(BookMap.containsKey(Id)){
            return BookMap.get(Id);
        }else{
            return null;
        }
    }
    void displayBooks(){
        for(int i = 0;i<books.size();i++){
            System.out.println(books.get(i));
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while(true){

            System.out.println("Welcome to Library System,refer the menu to flow through and enter any negative value to exit  ->");
            System.out.println("1 -> Add Book");
            System.out.println("2 -> Add Member");
            System.out.println("3 -> Remove Book");
            System.out.println("4 -> Issue Book");
            System.out.println("5 -> Return Book");
            System.out.println("6 -> Find Book");
            System.out.println("7-> Display Books");
            
            int x = scanner.nextInt();
            if(x < 0) break;
            else if(x == 1){
                System.out.println("Enter the book ID");
                Integer id = scanner.nextInt();

                System.out.println("Enter the Author Name");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.println("Enter the Title");
                String Title = scanner.nextLine();

                boolean a = true;

                library.addBook(id,name,a,Title);

            }else if(x == 2){
                
                System.out.println("Enter the Member ID");
                Integer id = scanner.nextInt();

                System.out.println("Enter the Member Name");
                scanner.nextLine();
                String name = scanner.nextLine();

                library.registerMember(id, name);

            }else if(x == 3){
                 System.out.println("Enter the Book ID");
                Integer id = scanner.nextInt();
                library.removeBook(id);
            }else if(x == 4){
                System.out.println("Enter the Book ID");
                Integer bid = scanner.nextInt();
                System.out.println("Enter the Member ID");
                Integer Mid = scanner.nextInt();

                library.issueBook(bid,Mid);
            }else if(x == 5){
                System.out.println("Enter the Book ID");
                Integer bid = scanner.nextInt();
                System.out.println("Enter the Member ID");
                Integer Mid = scanner.nextInt();

                library.returnBook(Mid,bid);
            }else if(x == 6){
                System.out.println("Enter the Book ID");
                Integer bid = scanner.nextInt();
                System.out.println(library.findBook(bid));
            }else if( x == 7){
                library.displayBooks();
            }
            

        }

        scanner.close();

    }
}
