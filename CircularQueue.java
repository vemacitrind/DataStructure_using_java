import java.util.Scanner;

public class CircularQueue {
    int []q;
    int size;
    int f;
    int r;
    CircularQueue(int size){
        this.size = size;
        q = new int[size];
        f = -1;
        r = -1;
    }
    public void enQueue(int val){
        if (r+1==f || (f==0 && r+1==size)) {
            System.out.println("Over Flow");
        }else{
            if (f == -1) {
                f = 0;
            }
            r = (r+1) % size;
            q[r] = val;
            System.out.println("Insert successfully!");
        }
    }
    public int deQueue(){
        if (f == -1) {
            System.out.println("Under flow");
            return -1;
        }else{
            int y = q[f];
            if (f == r) {
                f = -1;
                r = -1;
                return y;
            }
            f = (f+1) % size;
            return y;
        }
    }
    public void display(){
        System.out.print("[");
        for(int i = f; i != r ;i = (i+1)% size){
            System.out.print(q[i]+", ");
        }System.out.println(q[r]+"]");
    }
    
    
}
class Main3 {
    public static void main(String[] args) {
        CircularQueue n = new CircularQueue(5);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.enQueue");
            System.out.println("2.deQueue");
            System.out.println("3.display");
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
                case 6 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid number");
            }
        }while(true);
    }
}