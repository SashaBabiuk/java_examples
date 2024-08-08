package lambda;

//Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
//Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное
//число делится без остатка на 13.

public class Example1 {
    public static void main(String[] args) {
        NumberPredicate isDivisibleBy13 = (number) -> number % 13 == 0;

        System.out.println(isDivisibleBy13.test(14));
    }
}

//функціональний інтерфейс
interface NumberPredicate {
    boolean test(int number);
}
