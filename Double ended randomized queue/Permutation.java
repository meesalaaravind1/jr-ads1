import edu.princeton.cs.algs4.StdIn;

public class Permutation{
    public static void main(String[] args) {
        int i=Integer.parseInt(args[0]);
        RandomizedQueue<String> queue=new RandomizedQueue<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            queue.enqueue(item);
        }

        for (int j=0;j<i;j++){
            System.out.println(queue.dequeue());
        }
    }
}