import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean cond = true;
        int amount ;
        int percent;
        while (cond){

            Employee ee = new Employee("1415","Ali",15000);
        Account bb = new Account("1010","Ayob",20000);

//            System.out.println("raisedSalary : "+ee.raisedSalary(20));
//            System.out.println(ee.toString());
            Account another = new Account("1110","Ayob",10100);
        Account aa = new Account("1011","Ahmed");

//            System.out.println("name :"+aa.getName()+" Id: "+aa.getId());
//            System.out.println("name :"+aa.getName()+" Id: "+aa.getId()+" balnce : "+ aa.getBalnce());
//            System.out.println("name :"+ee.getName()+" Id: "+ee.getId());
//            System.out.println("name :"+ee.getName()+" Id: "+ee.getId()+" balnce : "+ ee.getSalary());
//            System.out.println("name :"+bb.getName()+" Id: "+bb.getId());
//            System.out.println("name :"+bb.getName()+" Id: "+bb.getId()+" balnce : "+ bb.getBalnce());

//            System.out.println(bb.getCredit());

//        System.out.println(aa+"   "+ bb);
//        System.out.println(bb.getBalnce());
//            aa.setCredit(50);
//
//            aa.TransferTo(another,10);
//            System.out.println(another.getBalnce());
//
//            System.out.println(aa.getCredit());
//            aa.setDebit(100);
//            System.out.println(aa.getDebit());
            System.out.println("1-to credit :\n" +
                    "\n" +
                    "2- to debit :\n" +
                    "\n" +
                    "3- to transfer :\n" +
                    "\n" +
                    "4- to get  Annul Salry :\n" +
                    "\n" +
                    "5- to get  Raised Salary :\n" +
                    "\n" +
                    "6- to get  toString(Account class) :\n" +
                    "\n" +
                    "7- to get  toString(Employee class) :\n" +
                    "\n" +
                    "0- To Stop");
        int num = s.nextInt();
        if (num == 0){
            cond = false;
            break;
        }
        switch (num){
            case 1:
                System.out.println("anter your amont to credit :");

                bb.setCredit(amount = s.nextInt());
                System.out.println(bb.getCredit());
                break;

            case 2:
                System.out.println("anter your amont to debit :");

                bb.setDebit(amount= s.nextInt());
                System.out.println(bb.getDebit());
                break;
            case 3:
                System.out.println("anter your amont to transfer :");
                amount=s.nextInt();

            bb.TransferTo(another,amount);

                System.out.println("after transfermtion :"+another.getBalnce());
            break;
                //trnsferTO
            case 4:

                System.out.println(ee.getAnnulSalry());
            break;
                //AnnulSalary
            case 5:
                System.out.println("anter your amont to percent :");
                percent=s.nextInt();
                System.out.println(ee.raisedSalary(percent));
                break;

                //raisedSalary
            case 6:
                System.out.println(bb.toString());
                break;
            case 7:
                System.out.println(ee.toString());
                break;
        }

        }



    }
}