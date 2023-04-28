import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Введите выражение - ");
                System.out.println("Результат выражения = " + calc(scanner.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("Неправильный ввод!");
        }
    }

    public static String calc(String input) throws IOException {

        int lengthStr = input.length();
        byte a, b;

        switch (lengthStr) {
            case 3:
                if (Character.isDigit(input.charAt(0)) && IsSign(input.charAt(1)) && Character.isDigit(input.charAt(2))) {  //a+b
                    a = Byte.parseByte(input.substring(0, 1));
                    b = Byte.parseByte(input.substring(2, 3));
                    if (NotInTheRange(a, b)) throw new IOException();
                    return CalculateArabicExpression(a, b, input.charAt(1));
                }
            case 4:
                if (Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1)) && IsSign(input.charAt(2)) && Character.isDigit(input.charAt(3))) { //aa+b
                    a = Byte.parseByte(input.substring(0, 2));
                    b = Byte.parseByte(input.substring(3, 4));
                    if (NotInTheRange(a, b)) throw new IOException();
                    return CalculateArabicExpression(a, b, input.charAt(2));
                }
                if (Character.isDigit(input.charAt(0)) && IsSign(input.charAt(1)) && Character.isDigit(input.charAt(2)) && Character.isDigit(input.charAt(3))) {//a+bb
                    a = Byte.parseByte(input.substring(0, 1));
                    b = Byte.parseByte(input.substring(2, 4));
                    if (NotInTheRange(a, b)) throw new IOException();
                    return CalculateArabicExpression(a, b, input.charAt(1));
                }
                break;
            case 5:
                if (Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1)) && IsSign(input.charAt(2)) && Character.isDigit(input.charAt(3)) && Character.isDigit(input.charAt(4))) { //aa+bb
                    a = Byte.parseByte(input.substring(0, 2));
                    b = Byte.parseByte(input.substring(3, 5));
                    if (NotInTheRange(a, b)) throw new IOException();
                    return CalculateArabicExpression(a, b, input.charAt(2));
                }
                break;
            default:
                //throw new IOException();
                break;
        }

//вычисление римского выражения
        byte indSign = 0;
        for (byte i = 1; i < input.length() - 1; i++) {   //поиск знака в выражении
            if (IsSign(input.charAt(i))) {
                indSign = i;
                break;
            }
        }
        if (indSign == 0)
            throw new IOException(); //нет знака - это не выражение

String aStr=input.substring(0,indSign-1);
String bStr=input.substring(indSign+1,input.length());





/*
RomanNumerals I=RomanNumerals.I;
I.GetNumber();


        MyEnum e = MyEnum.Test1;
        String name = e.name(); // Returns "Test1"

*/

        
        return "555555555";
    }


    static boolean IsSign(char c) {                                //проверка на нужный знак
        if (c == '-' | c == '+' | c == '/' | c == '*') return true;
        return false;
    }

    static String CalculateArabicExpression(byte a, byte b, char s) throws IOException {
        switch (s) {
            case '+':
                return Integer.toString(a + b);
            case '-':
                return Integer.toString(a - b);
            case '*':
                return Integer.toString(a * b);
            case '/':
                return Integer.toString(a / b);
            default:
                throw new IOException();
        }
    }

    static boolean NotInTheRange(byte a, byte b) {
        return a < 1 || a > 10 || b < 1 || b > 10;
    }


}

