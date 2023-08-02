public class MoveablePoint implements Movable{

    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MoveablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }


    @Override
    public void moveUp() {
        y+=ySpeed;
        System.out.println("move Up = " +ySpeed);

    }

    @Override
    public void moveDown() {
        y-=ySpeed;
        System.out.println("move Down = "+ySpeed);
    }

    @Override
    public void moveLeft() {
        x-=xSpeed;
        System.out.println("move Left = "+xSpeed);
    }

    @Override
    public void moveRight() {
        x+=xSpeed;
        System.out.println("moveRight = "+xSpeed);
    }

    @Override
    public String toString() {
        return " Moveable Point " +
                " x= " + x +
                ", y= " + y +
                ", xSpeed= " + xSpeed +
                ", ySpeed= " + ySpeed ;
    }
}
