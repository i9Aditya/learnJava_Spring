class NewThread implements Runnable{
    Thread t;
    String name;
    NewThread(String Threadname){
        name = Threadname;
        t = new Thread(this,name);
        System.out.println("New Thread : " + t);
        t.start(); //calling run() method
    }

    public void run(){ //tells what the thread must do
        try{
            for(int i = 5;i>0;i--){
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("child interrupted.");
        }
    }

}

class ThreadImple extends Thread{
    ThreadImple(){
        super("Demo Thread");
        System.out.println(this.getName() + " " + this);
        start();
    }

    public void run(){
        try{
            for(int i = 5;i>0;i--){
                System.out.println(this.getName() + " " + i);
                Thread.sleep(700);
            }
        }catch(InterruptedException e){
            System.out.println("child interrupted.");
        }
    }
}

public class MultiThreading {
    public static void main(String[] arg){
        // new ThreadImple();
        // new NewThread("one");
        // new NewThread("Two");
        // new NewThread("Three");

        // try{
        //     for(int i = 5;i>0;i--){
        //         System.out.println("Main thread:" + i);
        //         Thread.sleep(1000);
        //     }
        // }catch(InterruptedException e){
        //     System.out.println("Main thread interrupted");
        // }
        // System.out.println("Exiting main thread!");

        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        System.out.println("Thread One is Alive : " + ob1.t.isAlive());
        System.out.println("Thread Two is Alive : " + ob2.t.isAlive());
        System.out.println("Thread Three is Alive : " + ob3.t.isAlive());

        try{
            System.out.println("Waiting for threads to finish");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch(InterruptedException e){
            System.out.print("Main Thread interrupted\n");
        }
        System.out.println("Thread One is Alive : " + ob1.t.isAlive());
        System.out.println("Thread Two is Alive : " + ob2.t.isAlive());
        System.out.println("Thread Three is Alive : " + ob3.t.isAlive());



        System.out.println("Exiting main thread!");
        
    }
}
