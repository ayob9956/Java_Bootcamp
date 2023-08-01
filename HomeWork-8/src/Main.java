import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.###");

        Shape sh = new Shape();
        sh.setColor("Green");
        sh.setFilled(true);
        System.out.println(sh);
        //
        Shape sh2 = new Shape("Red",true);
        System.out.println(sh2);
        //

        Circle ci = new Circle();
        ci.setRadius(4.9);
        System.out.println(ci);

        //
        Rectangle re = new Rectangle(50,10);
        System.out.println("Area is :"+re.getArea());
        System.out.println("Perimeter is"+re.getPerimeter());

        System.out.println(re);

        //

        Circle ci1 = new Circle();
        ci1.setRadius(1.0);
        System.out.println("Area is :"+df.format(ci1.getArea()));
        System.out.println("Perimeter is"+df.format(ci1.getPerimeter()));

        System.out.println(ci1);


        Square sq = new Square("black",false,2.0);
        Square sq1 = new Square();
        sq1.setSide(40);
        System.out.println(sq+"\n"+sq1.getArea());
        System.out.println("\n"+sq1.getPerimeter());
    }
}