package lambda;


import regularEx.Main;

//Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c
//и возвращает тоже дробное число. Написать реализацию такого интерфейса в виде лямбда-выражения,
// которое возвращает дискриминант. Кто забыл, D = b^2 — 4ac.
public class Example3 {
    public static void main(String[] args) {
        Discriminator discriminator = (double a,double b,double c) -> b * b - 4 * a * c;
        Discriminator NotDiscriminator = (double a,double b,double c) -> a * Math.pow(b,c);

        System.out.println(discriminator.discriminator(1,2,3));
        System.out.println(NotDiscriminator.discriminator(1,2,3));
    }
}

@FunctionalInterface
interface Discriminator{
    Double discriminator(double a,double b,double c);
}
