import java.util.*;

public class Main {
    public static ArrayList<Integer> postionForOne  = new ArrayList<>();
    public static ArrayList<Integer> postionForTow  = new ArrayList<>() ;


    public static void main(String[] args) {


        char[][] showGame = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        show(showGame);







        int postionForFirst ;



        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("enter postion 1-9");
            postionForFirst = s.nextInt();


            while (postionForOne.contains(postionForFirst)|| postionForTow.contains(postionForFirst)){


                postionForFirst = s.nextInt();

            }

            Random rand = new Random();

            adding(showGame, postionForFirst, "First");
            String result = win(showGame);
            if (!result.equals("")) {
                show(showGame);
                System.out.println(result);
                break;
            }
            if ((postionForOne.size()+postionForTow.size()) == 9){
                show(showGame);
                System.out.println("Game tie");

                break;
            }
            show(showGame);



            int postionForSecond = rand.nextInt(9) + 1;

while (postionForTow.contains(postionForSecond) || postionForOne.contains(postionForSecond)){


    postionForSecond = rand.nextInt(9) + 1;

}
            System.out.println(postionForSecond);
            adding(showGame, postionForSecond, "second");
            show(showGame);

            String result1 = win(showGame);
            if (!result1.equals("")) {
                show(showGame);
                System.out.println(result1);
                break;
            }

        if ((postionForOne.size()+postionForTow.size()) == 9){
            show(showGame);
            System.out.println("Game tie");
            break;
        }}

        }//main function


        public static void show( char[][] showGame){

            for (char[] row : showGame) {
                for (char charcters : row) {
                    System.out.print(charcters);
                }
                System.out.println();
            }
        }

public static void firstPostion(int postionForFirst ,char [][] showGame){

    Scanner sc = new Scanner(System.in);
    postionForFirst = sc.nextInt();
    adding(showGame, postionForFirst, "First");
    show(showGame);


}
public static int secondPostion(int postionForSecond, char [][] showGame){
        Random rand = new Random();
    postionForSecond = rand.nextInt(9) + 1;
    System.out.println(postionForSecond);
    adding(showGame, postionForSecond, "second");
    show(showGame);
    return postionForSecond;
}
public static void adding(char [][] showGame, int postion , String player) {
    char charctar = ' ';
    if (player == "First") {


        charctar = 'x';
        postionForOne.add(postion);

    } else if (player.equals("second")) {
        charctar = 'O';
        postionForTow.add(postion);

    }

    switch (postion) {
        case 1:
            showGame[0][0] = charctar;
            break;
        case 2:

            showGame[0][2] = charctar;
            break;
        case 3:

            showGame[0][4] = charctar;
            break;
        case 4:

            showGame[2][0] = charctar;
            break;
        case 5:

            showGame[2][2] = charctar;
            break;
        case 6:

            showGame[2][4] = charctar;
            break;
        case 7:

            showGame[4][0] = charctar;
            break;
        case 8:

            showGame[4][2] = charctar;
            break;
        case 9:

            showGame[4][4] = charctar;
            break;
        default:
            System.out.println("out of range !!");
            break;

    }

}
    public static String win(char[][] showGame) {
        if (showGame[0][0] == showGame[0][2]
        && showGame[0][2] == showGame[0][4] && showGame[0][0]!=' '){
            return showGame[0][0]+" is win";

        }else if (showGame[2][0] == showGame[2][2]
                && showGame[2][2] == showGame[2][4]&& showGame[2][0]!=' '){
            return showGame[2][0]+" is win";
        }else if (showGame[4][0] == showGame[4][2]
                && showGame[4][2] == showGame[4][4]&& showGame[4][0]!=' '){
            return showGame[4][0]+" is win";
        }else if (showGame[0][0] == showGame[2][0]
                && showGame[2][0] == showGame[4][0]&& showGame[0][0]!=' '){
            return showGame[0][0]+" is win";
        } else if (showGame[0][2] == showGame[2][2]
                && showGame[2][2] == showGame[4][2]&& showGame[0][2]!=' '){
            return showGame[0][2]+" is win";
        }else if (showGame[0][4] == showGame[2][4]
                && showGame[2][4] == showGame[4][4] && showGame[0][4]!=' '){
            return showGame[0][4]+" is win";
        }else if (showGame[0][0] == showGame[2][2]
                && showGame[2][2] == showGame[4][4]&& showGame[0][0]!=' '){
            return showGame[0][0]+" is win";
        } else if (showGame[0][4] == showGame[2][2]
                && showGame[2][2] == showGame[4][0]&& showGame[0][4]!=' '){
            return showGame[0][4]+" is win";
        }else {

        return "";
        }
    }

}//class main