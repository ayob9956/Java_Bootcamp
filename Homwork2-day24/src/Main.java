import javax.management.relation.Role;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        //Q1
//        System.out.println("enter your first number");
//        Scanner num1 = new Scanner(System.in);
//        int number1 = num1.nextInt();
//
//        System.out.println("enter your second number");
//        Scanner num2 = new Scanner(System.in);
//        int number2 = num2.nextInt();
//
//        int sum = number2 +number1;
//        int multiply = number1 * number2;
//        int subtract = number1 - number2;
//        int divide = number1 / number2;
//        int remainder = number1 % number2 ;
//        System.out.println(" Nuuumber   sum "+ sum + "  mu  "+ multiply +"  sub "+subtract+"  dev "+ divide+" rem  "+ remainder);


        //Q2

//        System.out.println("enter your text");
//        Scanner text = new Scanner(System.in);
//        String Text = text.nextLine();
//        System.out.println(Text.toLowerCase(Locale.ROOT));
//
//

        //Q3
//        System.out.println("enter your text");
//        Scanner text = new Scanner(System.in);
//        String Text = text.nextLine();
//        System.out.println(Text.charAt(1));


        //Q4

//        Scanner inNum = new Scanner(System.in);
//        System.out.println("enter your number :");
//        int sevednumber = inNum.nextInt();
//        if (sevednumber% 2 ==0){
//            System.out.println("it is Even");
//        }else {
//            System.out.println(" it is Odd");
//        }

        // Q5
//
//        Scanner enteredData = new Scanner(System.in);
//        System.out.println("enter your Role please :");
//        String Role = enteredData.nextLine();
//        if (Role.equals("admin")){
//            System.out.println("welcome admin");
//    } else if (Role.equals("superuser")){
//        System.out.println("welcome superuser");
//    }else if(Role.equals("user")){
//        System.out.println("welcome user");
//    }else{
//        System.out.println("wrong entered data");
//    }

        //Q6
//
//        Scanner cull = new Scanner(System.in);
//        System.out.println("enter First Number");
//        int first = cull.nextInt();
//        System.out.println("enter Second Number");
//        int second = cull.nextInt();
//        System.out.println("enter Third Number");
//        int third = cull.nextInt();
//        if (first+second == third){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }

        //Q7
//        Scanner cull = new Scanner(System.in);
//        System.out.println("enter First Number");
//        int first = cull.nextInt();
//        System.out.println("enter Second Number");
//        int second = cull.nextInt();
//        System.out.println("enter Third Number");
//        int third = cull.nextInt();
//        if (first >= second && first >= third){
//            System.out.println("The greatest:"+first);
//        }else if (second >=first && second >= third){
//            System.out.println("The greatest:"+second);
//        } else {
//            System.out.println("The greatest:"+third);
//
//        }
//
        Scanner enterr = new Scanner(System.in);
        System.out.println("enter weakday Number");
        int weakDay = enterr.nextInt();

        switch (weakDay){
            case 1:
                System.out.println("Sunday");break;
            case 2:
                System.out.println("Monday");break;
            case 3:
                System.out.println("Tuesday");break;
            case 4:
                System.out.println("Wednsday");break;
            case 5:
                System.out.println("Thersday");break;
            case 6:
                System.out.println("Friday");break;
            case 7:
                System.out.println("Satrday");break;
            default:
                System.out.println("out of range");
        }


    }}