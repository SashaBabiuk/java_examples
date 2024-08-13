package lambda.FunctionalInterface;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Person {
    String name;
    int age;

    static  Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
    };
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person person) {
        this.name = person.name;
        this.age = person.age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List.of(1, 2, 3, 4, 5, 6, 7, 8).forEach(i -> service.submit(() -> System.out.println(i)));
        service.shutdownNow();
        System.out.println(service.isTerminated());
    }
}
