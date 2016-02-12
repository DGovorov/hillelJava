import java.math.BigDecimal;

/**
 * Created by User on 09.02.2016.
 */
public class MyFirstClass
{
    public static void main(String args[]) {
        String message = "Hello World!";
        int birthday;
        birthday = 1991;
        int age = 2016 - birthday;
        message = "Hello, " + "world, I'm " + age;
        System.out.println(message);

        long millisecondsFromBCOverflow = 2016 * 365 * 24 * 3600 * 1000; //IDEA actually made a point on overflow
        System.out.println("Integer overflow = " + millisecondsFromBCOverflow);

        // long millisecondsFromBC = (long) 2016 * 365 * 24 * 3600 * 1000; // workaround
        long millisecondsFromBC = 2016L * 365L * 24L * 3600L * 1000L; // ATTENCIONE! POSSIBLE OVERFLOW!
        System.out.println("Correct result for millisecondsFromBC = " + millisecondsFromBC);

        long prettyBigNumber = 1_000_000_000;
        System.out.println(prettyBigNumber + " Compiler removes all '_' in numbers");

        int prettyBigNumberBinary = 0b1111_0100_0010_0100_0000; // ПРЕФИКСЫ для чисел
                                                                // 0b двоичные 0х шестеадцатеричные 0 восьмеричные(тупизм)
        System.out.println(prettyBigNumberBinary + " Turns out as one million");

        double howToDouble = 0x1.0p-3;                               // 16тиричное представление дробного числа 0,125
        System.out.println(howToDouble + " Thank you, Horstmann!");    // p=2

        //числа с плавающей точкой не используются в финансовых расчетах
        System.out.println(2.0 - 1.1 + " That's how we lose your money, sir"); // != 0.9

        char unicodePi = '\u03C0';
        System.out.println("\\u03C0 for " + unicodePi); // note \b \t \n \r \\ \" \'

        //int cantBeBoolean = 3;
        //if (cantBeBoolean)  {
        //    System.out.println("you will never see this message");
        //}
        //Error: java: incompatible types: int cannot be converted to boolean

        char whatIsInsideA = 'A';
        char whatIsInside5 = '5';
        char whatIsInsideSpace = ' ';
        System.out.println("A \t\t 5 \t\t Space");
        //checking chars with isJavaIdentifierPart
        System.out.print(Character.isJavaIdentifierPart(whatIsInsideA) +"\t");
        System.out.print(Character.isJavaIdentifierPart(whatIsInside5) +"\t");
        System.out.println(Character.isJavaIdentifierPart(whatIsInsideSpace));
        //checking chars with isJavaIdentifierStart
        System.out.print(Character.isJavaIdentifierStart(whatIsInsideA) +"\t");
        System.out.print(Character.isJavaIdentifierStart(whatIsInside5) +"\t");
        System.out.println(Character.isJavaIdentifierStart(whatIsInsideSpace));

        final double constPi = Math.PI;  //final for constants
        System.out.println(constPi);
    }

}

