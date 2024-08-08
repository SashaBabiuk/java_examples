package lambda.FunctionalInterface;

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
}
