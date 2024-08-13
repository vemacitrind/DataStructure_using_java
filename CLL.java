import java.util.Scanner;

public class CLL {
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
        Node n =new Node(data);
        if (head == null) {
            head = n;
            head.next = head;
        }else{
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }temp.next = n;
            n.next = head;
            head = n;
        }
    }

    void addLast(int data){
        Node n = new Node(data);
        if (head == null) {
            head = n;
            head.next = head;
        }else{
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = head;            
        }
    }

    void delFirst(){
        if (head == null) {
            System.out.println("CLL is empty");
        }else {
           if (head.next == head) {
                head = null;
                return;
           }Node temp = head;
           while (temp.next != head) {
                temp = temp.next;
           }
           head = head.next;
           temp = head;
        }
    }

    void delLast(){
        if (head == null) {
            System.out.println("CLL is empty");
        }else {
           if (head.next == head) {
                head = null;
                return;
           }Node temp = head;
           while (temp.next.next != head) {
                temp = temp.next;
           }
           temp.next = head;
        }
    }
    
    public boolean exit(int val){
        Node temp = head;
        do{
            if (temp.data == val) {
                return true;
            }temp = temp.next;
        }while(temp != head);
        return false;
    }
    
    void inserAfter(int val,int data){
        if (head == null) {
            System.out.println("Empty");
        }else{
            if (exit(val)) {
                Node tNode = head;
                do{
                    if (tNode.data == val) {
                        break;
                    }tNode = tNode.next;
                }while (tNode != head);
                Node n = new Node(data);
                n.next = tNode.next;
                tNode.next = n;
            }else{
                System.out.println(val+" don't exist");
            }
        }
    }
    
    void insertBefore(int val,int data){
        if (head == null) {
            System.out.println("Empty LinkedList");
        }else{
            if (head.data == val) {
                addFirst(data);
            }else{
                Node temp = head;
                Node tempPrevios ;
                do{
                    tempPrevios = temp;
                    temp = temp.next;
                    if (temp.data == val) {
                        break;
                    }
                }while(temp != head);
                Node n = new Node(data);
                n.next = temp;
                tempPrevios.next = n;
            }
        }
    }
    
    void display(){
        if (head == null) {
            System.out.println("Empty!");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }while (temp != head) ;
        System.out.println("null");
    }
    
    void insertOrdely(int data){
        Node n = new Node(data);
        if (head == null) {
            head = n;
            head.next = head;
        }else{            
            if (data < head.data  ) {
                n.next = head;
                head = n;
            }else{
                Node temp = head;
                Node tempPre ;
                do{
                    tempPre = temp;
                    temp = temp.next;
                    if ( data <temp.data ) {
                        break;
                    }
                }while(temp != head);
                tempPre.next = n;
                n.next = temp;
            }
        }
    }

}
class Main5 {
    public static void main(String[] args) {
        CLL n = new CLL();
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
                case 7 -> {
                    System.out.print("Enter value :");
                    int val = sc.nextInt();
                    System.out.print("Enter data :");
                    int data = sc.nextInt();
                    n.inserAfter(val, data);
                }
                case 8 -> {
                    System.out.print("Enter value :");
                    int val = sc.nextInt();
                    System.out.print("Enter data :");
                    int data = sc.nextInt();
                    n.insertBefore(val, data);
                }
                case 9 ->{
                    System.out.print("Enter data :");
                    int data = sc.nextInt();
                    n.insertOrdely(data);
                }
                case 6 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid number");
            }
        }while(true);
    }    
}