
public class Main {
    public static void main(String[] args) {

    MoveablePoint m = new MoveablePoint(50,20,90,80);
        System.out.println(m);
        m.moveUp();
        
        m.moveRight();

        System.out.println("After Move =  "+m);


    }
}