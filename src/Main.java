
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true)
        {
            System.out.println("Введите выражение!");
            calculator.Calculate(in.nextLine());
        }
    }
}