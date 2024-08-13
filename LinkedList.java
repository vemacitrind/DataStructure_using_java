import java.util.Scanner;

public class LinkedList {
    Node head = null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data){
        Node n = new Node(data);
        if (head == null) {
            head = n;
        }else{
            n.next = head;
            head = n;
        }
    }

    void addLast(int data){
        Node n = new Node(data);
        if (head == null) {
            head = n;
        }else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = n;
        }
    }

    void delFirst(){
        if (head == null) {
            System.out.println("CLL is empty");
        }else {
            Node h = head.next;
            head = h;
        }
    }

    void delLast(){
        if (head == null) {
            System.out.println("CLL is empty");
        }else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null; 
        }
    }

    void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }System.out.println("null");
    }
}
/**
* Main4
 */
class Main4 {
    public static void main(String[] args) {
        LinkedList n = new LinkedList();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.addFiest");
            System.out.println("2.addLast");
            System.out.println("3.delFirst");
            System.out.println("4.delLast");
            System.out.println("5.display");
            System.out.println("6.Exit");
            System.out.print("\nEnter choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value :");
                    int val = sc.nextInt();
                    n.addFirst(val);
                }
                case 2 -> {
                    System.out.print("Enter value :");
                    int val = sc.nextInt();
                    n.addLast(val);
                }
                case 3 -> n.delFirst();
                case 4 -> n.delLast();
                case 5 -> n.display();
                case 6 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid number");
            }
        }while(true);
    }    
}