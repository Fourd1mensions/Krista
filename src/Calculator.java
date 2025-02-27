public class Calculator {
    private double r, l, result;
    private char op;
    public boolean failed;

    public double getResult() { return result; }

    private boolean parseInput(String str) {
        String[] tokens = str.split(" ");
        if (tokens.length != 3) {
            System.out.println("Некорректный ввод выражения");
            return false;
        }
        try {
            r = Double.parseDouble(tokens[0]);
            l = Double.parseDouble(tokens[2]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
        if (tokens[1].length() != 1 || !"+-*/".contains(tokens[1])) {
            System.out.println("Некорректная операция");
            return false;
        }
        op = tokens[1].charAt(0);
        if (op == '/' && r == 0.0) {
            System.out.println("Деление на 0 недопустимо");
            return false;
        }
        return true;
    }

    private Calculator() {}

    public Calculator(String input) {
        if (!parseInput(input)) {
            failed = true;
            return;
        }
        switch (op) {
            case '+' :result = l + r;
            case '-' : result = l - r;
            case '*' : result = l * r;
            case '/' : result = l / r;
            default : failed = true;
        }
    }

}
