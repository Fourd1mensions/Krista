import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите выражение в формате 1 + 2 с пробелами: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Calculator calc = new Calculator(input);
        if(!calc.failed) System.out.printf("Результат: %.2f", calc.getResult());
        else             System.out.println("Рассчет не удался");
    }
}