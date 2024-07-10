package testTest;

public class Calculate {

    // Метод для додавання
    public double add(double a, double b) {
        return a + b;
    }

    // Метод для віднімання
    public double subtract(double a, double b) {
        return a - b;
    }

    // Метод для множення
    public double multiply(double a, double b) {
        return a * b;
    }

    // Метод для ділення
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
    public boolean evenOrOdd(int number){
        return number % 2 == 0;
    }

}