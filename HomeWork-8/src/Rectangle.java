public  class Rectangle extends Shape {
    private double width =1.0;
    private double length =1.0;



    public Rectangle(double side) {
        this.width = side;
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, String color, boolean filled) {
        super(color,filled);
        this.width = width;
    }

    public Rectangle(String color, boolean filled) {
        super(color,filled);
    }

    public Rectangle() {

    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }




    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                "} " + super.toString();
    }
    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }


}
