
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//  here I do try and catch for dvide by zero and empty stack
       ArrayList<Integer> total = new ArrayList<>() ;
        Scanner s = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        boolean q = true;

        int number;

        int num1=0;
        int num2=0;
        while (q!=false){
            System.out.print("Enter 1 to addition the numbers\n" +

                    "Enter 2 to subtraction the numbers\n" +

                    "Enter 3 to multiplication the numbers\n" +

                    "Enter 4 to division the numbers\n" +

                    "Enter 5 to modulus the numbers\n" +

                    "Enter 6 to find minimum number\n" +

                    "Enter 7 to find maximum number\n" +

                    "Enter 8 to find the average of numbers\n" +

                    "Enter 9 to print the last result in calculator\n"+

                    "Enter 10 to print the list of all results in calculator\n"+

                    "if you want yo trminte program enter 0\n"
                    );

            number = s.nextInt();
            if (number == 0){
                q=false;
                break;
            }
//            if(number == 9){
//                System.out.println(stack.pop());
//                continue;
//            }
//            if (number == 10){
//                System.out.println(stack);
//                continue;
//            }

            if (number != 9 && number !=10) {
                System.out.println("enter first Number:");
                num2 = s.nextInt();
                System.out.println("enter second number:");
                num1 = s.nextInt();
            }

            switch (number){



                case 1:

                    stack.push(sum(num1,num2)) ;

                    continue;
                case 2:
                stack.push(sub(num1,num2));
                continue;
                case 3: stack.push(mul(num1,num2)) ;
                continue;
                case 4:
                    try {
                        stack.push(div(num1,num2)) ;
                    }catch(Exception e1){
                        System.out.println(e1.getMessage());
                    }

                continue;
                case 5:stack.push(mod(num1,num2)) ;
                continue;
                case 6:min(num1,num2);
                continue;
                case 7: max(num1,num2);
                continue;
                case 8:
                    stack.push(avr(num1,num2)) ;
                continue;

                case 9:try {
                    checkEmpty(stack);
                    stack.peek();
                }catch (Exception e5){
                    System.out.println(e5.getMessage());
                }
                continue;

                case 10:
                    try {
                        checkEmpty(stack);
                        System.out.println(stack.pop());
                    }catch (Exception e5){
                        System.out.println("error : "+e5.getMessage());
                    }
continue;
                default:
                    System.out.println("wrong entered number 1-10 please do it agian :)");
            }


        }


}//Main
    public static int sum(int num1,int num2){
        int i = num1+num2;
        System.out.println(i);
        return i;
    }
    public static int sub(int num1,int num2){
        int i = num1-num2;
        System.out.println(i);
        return i;
    }
    public static int mul(int num1,int num2){
        int i = num1*num2;
        System.out.println(i);
        return i;
    }
    public static int div(int num1,int num2){
        int i = num1/num2;
        System.out.println(i);
        return i;
    }
    public static int mod(int num1,int num2){

        int i = num1%num2;
        System.out.println(i);
        return i;
    }
    public static void max(int num1,int num2){
        if (num1 > num2){
            System.out.println(num1);

        }else System.out.println(num2);
    }
    public static void min(int num1,int num2){
        if (num1 < num2){
            System.out.println(num1);

        }else System.out.println(num2);
    }
    public static int avr(int num1,int num2){

        int i = num1+num2;
        int av = i / 2;
        System.out.println(av);
        return av;
    }

    public static void checkEmpty(Stack<Integer> stack) throws Exception {

        if (stack.empty()){
            throw new Exception("the stack is empty!!");

    }
}}