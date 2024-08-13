import java.util.Scanner;

public class Stack{
    int []s;
    int size;
    int top;

    Stack(int size){
        this.size = size;
        s = new int[size];
        top = -1;
    }

    public void push(int val){
        if (top + 1 >=  size) {
            System.out.println("Stack Over Flow");
        }else {
            top = top + 1;
            s[top] = val;
            System.out.println("Value inserted successfully");
        }
    }

    public int pop(){
        if (top < 0) {
            System.out.println("Stack Under Flow");
            return -1;
        }else {
            int y = s[top];
            top = top - 1;
            return y;
        }
    }

    public int peep(int index){
        if (top + 1 - index <= 0) {
            System.out.println("Stack Under Flow");
            return -1;
        }else {
            return s[top + 1 -index];
        }
    }

    public void replace(int index1 , int index2){
        if (index1 < 0 || index1 > top || index2 < 0 || index2 > top) {
            System.out.println("Invalid indies");
        }else {
            int temp = s[index2];
            s[index2] = s[index1];
            s[index1] =  temp;
            System.out.println("Changed successfully!");
        }

    }
    
    public void display(){
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        for(int i = top ;i >= 0;i--){
            System.out.print(s[i]+", ");
        }System.out.println();
    }

    public int findPostfix(String expression){
        Stack n = new Stack(expression.length());
        for(int i =0 ;i < expression.length() ;i++){
            char x = expression.charAt(i);
            if (Character.isDigit(x)) {
                n.push(x - '0');
            }else{
                int x2 = n.pop();
                int x1 = n.pop();
                switch (x) {
                    case '+' -> n.push(x1 + x2);
                    case '-' -> n.push(x1 - x2);
                    case '*' -> n.push(x1 * x2);
                    case '/' -> n.push(x1 / x2);
                }
            }
        }
        return n.pop();
    }
    public int findPrefix(String expression){
        Stack n = new Stack(expression.length());
        for(int i = expression.length()-1 ;i >= 0;i--){
            char x = expression.charAt(i);
            if (Character.isDigit(x)) {
                n.push(x - '0');
            }else{
                int x1 = n.pop();
                int x2 = n.pop();
                switch (x) {
                    case '+' -> n.push(x1 + x2);
                    case '-' -> n.push(x1 - x2);
                    case '*' -> n.push(x1 * x2);
                    case '/' -> n.push(x1 / x2);
                }
            }
        }
        return n.pop();
    }
    

}
/**
 * Main
 */
class Main {

    public static void main(String[] args) {
        Stack n =  new Stack(5);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.Push");
            System.out.println("2.pop");
            System.out.println("3.peep");
            System.out.println("4.change");
            System.out.println("5.top");
            System.out.println("6.display");
            System.out.println("7.Evaluate postfix");
            System.out.println("7.Evaluate prefix");
            System.out.println("10.Exit");
            System.out.print("\nEnter choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value :");
                    int val = sc.nextInt();
                    n.push(val);
                }
                case 2 -> n.pop(); 
                case 3 -> {
                    System.out.print("Enter index :");
                    int index = sc.nextInt();
                    System.out.println(n.peep(index));
                }
                case 4 -> {
                    System.out.print("Enter index1 :");
                    int index1 = sc.nextInt();
                    System.out.print("Enter index2 :");
                    int index2 = sc.nextInt();
                    n.replace(index1,index2);
                }
                case 5 -> System.out.println(n.top);
                case 6 -> n.display();
                case 7 -> {
                    System.out.print("Enter expression : ");
                    String ex = sc.next();
                    System.out.println("Answer = "+n.findPostfix(ex));
                }
                case 8 -> {
                    System.out.print("Enter expression : ");
                    String ex = sc.next();
                    System.out.println("Answer = "+n.findPrefix(ex));
                }
                case 10 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid number");
            }
        }while(true);
    }
}