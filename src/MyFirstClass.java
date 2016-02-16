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

        System.out.println("=====WORKING AROUND OVERFLOW=====");
        long millisecondsFromBCOverflow = 2016 * 365 * 24 * 3600 * 1000; //IDEA actually made a point on overflow
        System.out.println("Integer overflow = " + millisecondsFromBCOverflow);

        // long millisecondsFromBC = (long) 2016 * 365 * 24 * 3600 * 1000; // workaround
        long millisecondsFromBC = 2016L * 365L * 24L * 3600L * 1000L; // ATTENCIONE! POSSIBLE OVERFLOW!
        System.out.println("Correct result for millisecondsFromBC = " + millisecondsFromBC);

        System.out.println("=====COMFORTABLE ENTRY FORM=====");
        long prettyBigNumber = 1_000_000_000;
        System.out.println(prettyBigNumber + " Compiler removes all '_' in numbers");

        int prettyBigNumberBinary = 0b1111_0100_0010_0100_0000; // ПРЕФИКСЫ для чисел
                                                                // 0b двоичные 0х шестеадцатеричные 0 восьмеричные(тупизм)
        System.out.println(prettyBigNumberBinary + " Turns out as one million");

        System.out.println("=====WORKING WITH DOUBLE=====");
        double howToDouble = 0x1.0p-3;                               // 16тиричное представление дробного числа 0,125
        System.out.println(howToDouble + " Thank you, Horstmann!");    // p=2

        //числа с плавающей точкой не используются в финансовых расчетах
        System.out.println(2.0 - 1.1 + " That's how we lose your money, sir"); // != 0.9

        System.out.println("=====USING LITERALS=====");
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

        System.out.println("=====\"FINAL\" FOR CONSTANT=====");
        final double CONST_PI = Math.PI;  //final for constants, usually named in upper case
        System.out.println(CONST_PI);

        System.out.println("=====DOUBLE CAN BE NaN=====");
        double notANumber = -10.0 / 0;  //double divided by zero contains NaN or Infinity or -Infinity
        System.out.println(notANumber); //int divided by zero would generate an exception
                                        //operator "=" has lower priority than "/"
                                        //"10" HAS to be real ===> "10.0"

        //public static strictfp void nameMethod(String args[]){}
        //              strictfp - магическое слово для одинаковых точных вычислений на любых виртуальных машинах,
        //которое, возможно, и применяться то нами не будет. Может вызвать переполнение?

        System.out.println("=====LOGICAL OPERATOR \"&&\"=====");
        int ifNotZero = 5;
        boolean logicalOperatorAnd = (ifNotZero != 0 && 1 / ifNotZero > ifNotZero); //Don't divide by 0;
        System.out.println(logicalOperatorAnd);

        System.out.println("=====USING \"?:\" OPERATOR=====");
        int biggerA = 5;
        int biggerB = 7;
        System.out.println(biggerA > biggerB ? biggerA : biggerB); //returns bigger number

        int fourthBitFromRight = 24; // 24 ===> 11000
        System.out.println((fourthBitFromRight & 8) / 8); //returns 1 if fourth bit is 1;
        //Используя поразрядную операцию & в сочетании с соответствующей степенью 2 можно
        //замаскировать все биты кроме одного

        System.out.println();
        //операторы смещения
        int shiftingNumbers = 27;   // 11011 в двоичной
        System.out.println(shiftingNumbers>>>1); // 01101 в двоичной  !!!При отрицательном числе ставит 0 и в знаковом бите
        System.out.println(shiftingNumbers>>1); // 1101 в двоичном
        System.out.println(shiftingNumbers<<1); // 110110 в двоичном
                                                //применяется вместо умножения/деления на двойку в степени, для более быстрых вычислений.
        System.out.println(~0b11011);           //оператор побитового дополнения, черт его знает как работает, должен был выдать 00100

        System.out.println();
        double sqrtNumber = 25.0;
        double powNumber = 6.0;
        double exponentNumber = 4.0;
        System.out.println(Math.sqrt(sqrtNumber));              //square root
        System.out.println(Math.pow(powNumber,exponentNumber)); //involution
                                                                //both always return result in double
        System.out.println(Math.round(9.982));          //return type long

        System.out.println();
        boolean makingItInt = true;
        int nowItsInt = makingItInt ? 1 : 0;
        System.out.println(nowItsInt);

        System.out.println();
        //enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE} //enum must not be local
        Size pizza = Size.MEDIUM;
        System.out.println(pizza);

        System.out.println();
        String greeting = "Hello!";
        String subGreeting = greeting.substring(0,3); //substring length always is end-start = 3-0 = 3;
        System.out.println(subGreeting);              //"Hel" 0,1,2 symbols.
    }
    enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}
}

