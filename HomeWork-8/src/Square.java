public class Square extends Rectangle {

    public  Square(double side){
        super(side,side);
    }
    public Square(String color,boolean filled,double side){
        super(color,filled);


    }

    public Square() {
        super();
    }


    public double getSide() {

        return super.getWidth();
    }


    public void setSide(double width) {
        super.setWidth(width);

    }
    public double getArea(){
        return 2 *getSide();
    }
    public double getPerimeter(){
        return 4 * getSide();
    }

    @Override
    public String toString() {
        return "Square Hello from Square class!!  " + super.toString();
    }
}
