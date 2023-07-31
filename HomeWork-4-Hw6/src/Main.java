import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        //        ArrayList<Integer> Q1 = new ArrayList<Integer>();
//
//        Q1.add(50);
//        Q1.add(-20);
//        Q1.add(0);
//        Q1.add(30);
//        Q1.add(40);
//        Q1.add(10);
//
//
//
//        if (Q1.get(0) == Q1.get(Q1.size()-1)){
//            System.out.println(true);
//
//
//        }else {
//            System.out.println(false);
//        }
//
//
//
//        ArrayList<Integer> q2 = new ArrayList<>();
//
//
//int max =0;
//
//        for (int l=0 ;l<6 ; l++){
//
//            System.out.println("enter Number to check the largest in this array  :");
//            q2.add(s.nextInt());
//             if(q2.get(l) >max){
//                 int temp =0;
//                 temp =q2.get(l);
//                 max = temp;
//                 max = q2.get(l);
//
//
//
//
//            }}
//        System.out.println(" the larges is "+ max);
//
//
//        System.out.println(q2);

////Q3
//        ArrayList<Integer> q3 = new ArrayList<>();
//
//
//        int avrage =0;
//        int  num=6;
//        for (int l=0 ;l<num ; l++){
//
//            System.out.println("enter 6 Numbers to check the largest in this array  :");
//            q3.add(s.nextInt());
//
//            avrage += q3.get(l);
//
//
//
//            }
//
//        avrage = avrage / num;
//        for (int y = 0 ;y < num ; y++){
//            if (avrage < q3.get(y)){
//                System.out.println("the number largest than avarge is :"+q3.get(y));
//            }
//        }
//
//        System.out.println(" the avrage is "+ avrage);
//
//
//        System.out.println(q3);
//

///Q4

//        ArrayList<Integer> q4 = new ArrayList<>();
//
//
//        int avrage =0;
//        int  num=6;
//        for (int l=0 ;l<num ; l++){
//
//            System.out.println("enter 6 Numbers to check the largest in this array  :");
//            q4.add(s.nextInt());
//            if(l==0 || l==5){
//                avrage += q4.get(l);
//            }
//
//        }
//
//        avrage = avrage / 2;
//        for (int y = 0 ;y < num ; y++){
//            if (avrage < q4.get(y)){
//                System.out.println("the number largest than avarge is :"+q4.get(y));
//            }
//        }
//
//        System.out.println(" the avrage is "+ avrage);
//
//
//        System.out.println(q4);


//        ArrayList<Integer> q5 = new ArrayList<>();
//        ArrayList<Integer> nA = new ArrayList<>();
//
//
//        for (int i = 0 ; i<6 ; i++ ){
//            System.out.println("enter 6 Number to swap boundris");
//            q5.add(s.nextInt());
//            System.out.println(q5);
//        }
//        int temp = q5.get(0);
//         q5.set(0, q5.get(q5.size()-1)) ;
//         q5.set(q5.size()-1, temp);
//
//
//
//        for (int hj = 0 ;hj< q5.size();hj++){
//        nA.add(hj,q5.get(hj));
//        }
//
//
//        System.out.println(nA);


        //Q6
//
//        ArrayList<String> q6 = new ArrayList<>();
//        q6.add("cat");
//        q6.add("dog");
//        q6.add("red");
//        q6.add("is");
//        q6.add("am");
//        System.out.println(q6);
//
//
//        int lon = 0,cunt=0;
//        for(String w : q6) {
//            if (w.length() > lon) {
//                lon = w.length();
//
//
//                for (String sd: q6 ) {
//                    if (sd.length()==lon){
//                        System.out.println(sd);// here if we have more than 3
//                        // charcters we shold use second for out side first loop
//                    }
//                }
//

        //            }
        //
        //        }

        // Q7   // this Q i did not understand how become the the loop stil work
        //and i putet in swich the menu but that not comblete

        // i make here try and catch for check the array is empty before sort!
        ArrayList<Integer> Q7 = new ArrayList<>();
        boolean condetion = true;
        int menu = 0;
        int value = 0;
        while (condetion) {
            System.out.println("enter number to choice in menu :" +
                    "\n1-Accept elements of an array\n" +
                    "\n" +
                    "2-Display elements of an array\n" +
                    "\n" +
                    "3-Search the element within array\n" +
                    "\n" +
                    "4-Sort the array\n" +
                    "\n" +
                    "5-To Stop");

                menu = s.nextInt();



            switch (menu) {
                case 1:

                        System.out.println("enter your value : ");
                        value = s.nextInt();
                        Q7.add(value);
                        System.out.println(Q7);


                    break;

                case 2:
                    System.out.println(Q7);
                    break;
                case 3:
                    System.out.println("enter your value : ");
                    value = s.nextInt();
                    try {
                        try {
                            checkEmpty(Q7);
                        } catch (Exception e4) {
                            System.out.println(e4.getMessage());
                        }
                        checkVallid(Q7, value);
                    } catch (Exception e5) {
                        System.out.println(e5.getMessage());
                    }
                    break;
                case 4:
// i make here try and catch for check the array is empty before sort!
                    try {
                        checkEmpty(Q7);
                        Collections.sort(Q7);
                        System.out.println(Q7);
                    } catch (Exception e4) {
                        System.out.println(e4.getMessage());
                    }

                    break;
                case 5:
                    condetion = false;

                    break;
                default:
                   break;
            }
        }

//
        //Q8
//        int n, x, count = 0, i = 0;
//        System.out.println("enter size you want ");
//        n = s.nextInt();
//        int a[] = new int[n];
//        System.out.println("enter all the elements:");
//        for(i = 0; i < n; i++)
//        {
//            a[i] = s.nextInt();
//        }
//        System.out.print("Enter the number of which you want count");
//        x = s.nextInt();
//        for(i = 0; i < n; i++)
//        {
//            if(a[i] == x)
//            {
//                count++;
//            }
//        }
//        System.out.println(x+" number occurs of the number is "+count+" times");
//


//        //Q9  this Q i see the algorthim in internet and i understand the how put number in left array and the right.
//        int arr[] = {2,3,40,1,5,9,4,10,7};
//
//        int lef = 0, ri = arr.length - 1;
//        while (lef < ri)
//        {
//
//            while (arr[lef]%2 == 0 && lef < ri)
//                lef++;
//
//
//            while (arr[ri]%2 == 1 && lef < ri)
//                ri--;
//
//            if (lef < ri)
//            {
//
//                int temp = arr[lef];
//                arr[lef] = arr[ri];
//                arr[ri] = temp;
//                lef++;
//                ri--;
//            }
//        }
//
//        System.out.print("array after order the odd sprate odd and even ");
//        for (int i = arr.length-1; i > 0; i--)
//            System.out.print(arr[i]+" ");
//
//
//

//        //Q10
//        int [] arr1 = {2,3,6,6,4};
//        int [] arr2 = {2,3,6,6,4};
//        System.out.println(Arrays.equals(arr1, arr2));
//    }
//    }
    }

    public static void checkVallid(ArrayList<Integer> Q7, int value) throws Exception {
        if (!Q7.contains(value)) {
            throw new Exception("the ArrayList is Not contains this value!!");
        }
    }

    public static void checkEmpty(ArrayList<Integer> Q7) throws Exception {
        if (Q7.isEmpty()) {
            throw new Exception("the ArrayList is empty!!");
        }

    }

}
