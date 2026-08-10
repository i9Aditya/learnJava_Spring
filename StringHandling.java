import java.util.Arrays;

class Boxx{
    double width;
    double height;
    double depth;

    Boxx(double w, double h,double d){
        width = w;
        height = h;
        depth = d;
    }

    public String toString(){
        return "Dimesions are " + width + "by " + "depth " +height + ".";
    }
}

public class StringHandling {
    
    public static void main(String[] args){
        String s = new String("This is declaration of the first string");
        s = s + ". However";
        //System.out.println(s);

        String lngStr = "This could have been a " + "C++ program " + "Or a C program but "+ "its a Java Program.";
        System.out.println(lngStr);

        Boxx b = new Boxx(10.1,20.2,30.3);
        String str = "Box : b" + b;

        // System.out.println(b);
        // System.out.println(str);


        // charAt(index) -> returns the character at specified index.
        char a = str.charAt(2);
         //System.out.println(a);

         //Implementing getchar(int sourceStart, int sourceEnd,char target[],int targetStart);

         int start = 5;
         int end = 16;

         char te[] = new char[end - start];
         lngStr.getChars(start, end,te, 0);
         System.out.println(te);

         //getByte() used as an alternative for getChars
         byte[] check = lngStr.getBytes();
         //System.out.println(Arrays.toString(check));
         //Crazy implementation

         // equals() && equalsIgnoreCase() -> comparison use case
         // compareTo() -> best method to compare the two strings



// StringBuilder
// J2SE 5 adds a new string class to Java’s already powerful string handling capabilities. This
// new class is called StringBuilder. It is identical to StringBuffer except for one important
// difference: it is not synchronized, which means that it is not thread-safe. The advantage of
// StringBuilder is faster performance. However, in cases in which you are using multithreading,
// you must use StringBuffer rather than StringBuilder.




    }


}
