import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException{
        int i; //"i contains the byte value returned by read() as an int, or -1 when the end of the file is reached."
        FileInputStream fin;
        FileOutputStream fout;
        // try{
        //     fin = new FileInputStream("the_echoing_cave.txt");
        // }catch(FileNotFoundException e){
        //     System.out.println("File Not Found");
        //     return;
        // }catch(ArrayIndexOutOfBoundsException e){
        //     System.out.println("Usage: Show File ");
        //     return;
        // }

        // do{
        //     i = fin.read();
        //     if(i != -1) System.out.print((char) i);
        // }while(i  != -1);

        try{
            try{
                fin = new FileInputStream("the_echoing_cave.txt");

            }catch(FileNotFoundException e){
                System.out.println("Input File Not Found");
                return;
            }
            try{
                fout = new FileOutputStream("example.txt");
            }catch(FileNotFoundException e){
                System.out.println("File not found");
                return;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Usage : CopyFile form to");
            return;
        }

        //copy file
        try{
            do{
                i = fin.read();
                if(i != -1){
                    fout.write(i);
                }
            }while(i != -1);
        }catch(IOException e){
                System.out.print("File Error");
            }

        fin.close();
        fout.close();
        }
        
        
}

