import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        //Q1
//    for (int i =0;i<=100;i++){
//        if (i % 3 ==0){
//            System.out.println("Fizz :"+i);
//        } else if (i % 5 == 0) {
//            System.out.println("Buzz :"+i);
//
//        } else if (i % 3 ==0 && i % 5 ==0 ) {
//            System.out.println("FizzBuzz :"+i);
//
//        }
//    }

    //Q2
        Scanner s =new Scanner(System.in);
//        String e = s.nextLine();
//        String t ="";
//        for (int j = e.length()-1;j!=0;j--){
//
//            t = t + e.charAt(j);/* here the index start from 0
//            becuse that if I deleted the e.length()"-1" will get erorre "out of Range"*/
//
//
//        }System.out.println(t);

        //Q3

//        int w;
//        System.out.println("enter the number you want to multyplay from 1 to 12");
//
//        w = s.nextInt();
//        for (int p = 12 ;p>=0;p--){
//            int z = w * p ;
//            System.out.println("the number "+p+" with your enterd "+w+" the resulte is "+z);
//        }


        //Q4
//        System.out.println("Enter The Number to factorial: ");
//        int enteredNumber = s.nextInt();
//        int fact =1;
//        for (int y = 1;y <= enteredNumber ; y++){
//            fact = fact * y;
//        }
//        System.out.println("The factorial is "+fact);
            //q5



//        System.out.println("Enter The Number to Power: ");
//        int enteredNumber1 = s.nextInt();
//        System.out.println("Enter TheSecond Number to Power: ");
//        int po =s.nextInt();
//        int powerofNumberIs = 0;
//        for (po = po ; po >0 ; po--){
//            powerofNumberIs  =enteredNumber1 * enteredNumber1;
//       }
//        System.out.println("The Power is " + powerofNumberIs);

        //Q6


//        int t = s.nextInt();
//        int sumOdd=0,sumEven=0;
//        for (int m = t ; m>0; m--){
//
//
//            if (m%2 == 0){
//                sumEven = sumEven+m;
//            }
//            if (m%2!=0){
//                sumOdd = sumOdd+m;
//
//            }
//        }   System.out.println("the sum of odd is "+sumOdd+"and the sum of Even is :"+sumEven);
//


        //Q7
//        System.out.println("enter value to check");
//        int pr = s.nextInt();
//        int conter =0 ;
//
//      for (int q = 2 ; q < pr; q++){
//
//          if(pr % q == 0 ){
//              ++conter;
//              break;
//          }
//
//          if (conter >0){
//              System.out.println(" the number is not prime   "+ pr );
//          }
//          } System.out.println(" it is prime  "+pr);
//
//
//
      // Q8
//
//       int neg = 0;
//       int pos = 0;
//       int zeros = 0;
//
//       for (int i=1 ; i>0;i++) {
//           System.out.println("enter number to check or 1 ot result : ");
//           int ent = s.nextInt();
//           if (ent == 1){
//               System.out.println("exit program:)");
//               break;
//           }
//
//
//           if (ent >0){
//               pos = pos +ent;
//
//           }
//           else if (ent < 0 ){
//               neg+=ent;
//
//           }
//           else if (ent == 0){
//               zeros++;
//
//           }
//       }
//        System.out.println("the sum of positve number is : "+pos);
//        System.out.println("the sum negtive number is : "+neg);
//        System.out.println("the sum of zeroes is :"+zeros);
//


        // Q9


//        for (int i =1 ; i<5; i++){
//            System.out.println("week is "+i);
//            for(int j=1; j<8; j++){
//                System.out.println(" day is "+j);
//            }
//        }

        //Q10
    String ert = "";
        System.out.println("enter String");
    String mj = s.nextLine();
    for (int i = mj.length()-1;i>=0;i--){
        ert = ert + mj.charAt(i);
        System.out.println(ert);
    }


    if (mj.toLowerCase() == ert.toLowerCase()){
        System.out.println("is a palindrome");

    }

    else {
        System.out.println("is NOT a palindrome");
    }

      }
    }
