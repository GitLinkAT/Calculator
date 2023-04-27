import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение - ");
        System.out.println("Результат выражения = " + calc(scanner.nextLine()));
    }

    public static String calc(String input) {


        return "rrr";
    }

    String DeleteSpace(String str) {                        //удаление всех пробелов
        return str = str.replaceAll(" ", "");
    }
    boolean IsSign(char c) {                                //проверка на нужный знак
        if (c == '-' | c == '+' | c == '/' | c == '*') return true;
        return false;
    }



}