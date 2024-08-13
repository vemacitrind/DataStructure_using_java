import java.util.Scanner;

public class Queue {
    int []q;
    int size;
    int f;
    int r;

    Queue(int size){
        this.size = size;
        q = new int[size];
        f = -1;
        r = -1;
    }

    public void enQueue(int val){
        if ((r+1) >= size) {
            System.out.println("Queue Over flow");
        }else{
            if (f == -1) f = 0;
            r = r + 1;
            q[r] = val;
            System.out.println("Inserted successfully!");
        }
    }

    public int deQueue(){
        if (f == -1) {
            System.out.println("Queue Under flow");
            return -1;
        }else {
            int y = q[f];
            if (f == r) {
                f = -1;
                r = -1;
                return y;
            }
            f = f + 1;
            return y;
        }
    }

    public void display(){
        if (f == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("[");
        for(int i = f ;i <= r;i++){
            System.out.print(q[i]);
            if (i != r) {
                System.out.print(", ");
            }
        }System.out.println("]");
    }

    public int peekFirst(){
        if (f == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return q[f];
    }

    public int peekLast(){
        if (r == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return q[r];
    }
    

}
class Main2 {

    public static void main(String[] args) {
        Queue n =  new Queue(5);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.enQueue");
            System.out.println("2.deQueue");
            System.out.println("3.display");
            System.out.println("4.peekfirst");
            System.out.println("5.peeklast");
            System.out.println("6.Exit");
            System.out.print("\nEnter choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value :");
                    int val = sc.nextInt();
                    n.enQueue(val);
                }
                case 2 -> System.out.println("Deleted value is : "+n.deQueue());
                case 3 -> n.display();
                case 4 -> System.out.println(n.peekFirst());
                case 5 -> System.out.println(n.peekLast());
                case 6 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid number");
            }
        }while(true);
    }
}