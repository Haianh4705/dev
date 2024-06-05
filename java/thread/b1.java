package thread;
import java.util.ArrayList;
import java.util.Random;


 class Thread1 extends Thread {
    ArrayList<Integer> list1 = new ArrayList<>();
    Random rand = new Random();
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            try {
                Thread.sleep(100);
                list1.add(rand.nextInt(50) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}

    class Thread2 extends Thread {
    ArrayList<Character> list2 = new ArrayList<>();
    Random rand = new Random();

    @Override
        public void run() {
            for (int i = 0; i<10; i++) {
                try {
                    Thread.sleep(200);
                    char c = (char) (rand.nextInt(26) + 'a');
                    this.list2.add(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
            }
        }
}

public class b1 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {

        }

        System.out.println(t1.list1);
        System.out.println(t2.list2);
    }
}