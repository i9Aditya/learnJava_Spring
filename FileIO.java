import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException{
        int i;
        FileInputStream fin;

        try{
            fin = new FileInputStream("the_echoing_cave.txt");
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
            return;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Usage: Show File ");
            return;
        }

        do{
            i = fin.read();
            if(i != -1) System.out.print((char) i);
        }while(i  != -1);

        fin.close();
        
    }
}
