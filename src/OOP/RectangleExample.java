package OOP;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by User on 26.02.2016.
 */
public class RectangleExample {
    public static void main(String[] args) {
        Rectangle firstRectangle = new Rectangle();
        firstRectangle.setHeight(2);
        firstRectangle.setWidth(3);
        firstRectangle.setColor("Blue");

        int w = firstRectangle.getWidth();
        int a = firstRectangle.calculateArea();

        System.out.println(firstRectangle.getHeight());
        System.out.println(firstRectangle.getColor());

        Rectangle secondRectangle = new Rectangle();
        secondRectangle.setHeight(5);
        secondRectangle.setWidth(10);
        System.out.println("rectangle's color is " + secondRectangle.getColor());

        secondRectangle.calculateArea();

        int firstRectangleWidth = 3;
        int firstRectangleHeight = 4;
        int secondRectangleWidth = 5;
        int secondRectangleHeight = 10;

        int area = calculateArea(firstRectangleHeight, secondRectangleWidth);

        area = calculateArea(firstRectangle);

        System.out.println(area);

        Rectangle thirdRectangle = null;

       // thirdRectangle.calculateArea();
        firstRectangle.setWidth(4);

/*        Rectangle fourthRectangle = null;
        System.out.println(thirdRectangle.color == fourthRectangle.color);*/

       // anotherMethod();

        //System.out.println("======>" + firstRectangle);

        System.out.println("first rect is " + firstRectangle.toString());

        Rectangle anotherRectangle = new Rectangle(firstRectangle.getWidth(), firstRectangle.getHeight());
        System.out.println("another rectangle is " + anotherRectangle.toString());

        System.out.println(firstRectangle == anotherRectangle);

        System.out.println(firstRectangle.equals(anotherRectangle));

    }

/*    public static void anotherMethod (){
        int i = 10;
        System.out.println("sdasf");
        anotherAnotherMethod();
    }

    public static void anotherAnotherMethod(){
        Rectangle rectangle = null;
        rectangle.calculateArea();
    }*/

    public static int calculateArea(int height, int width) {
        return height * width;
    }

    public static int calculateArea(Rectangle rectangle) {
        return rectangle.getHeight() * rectangle.getWidth();
    }

}
