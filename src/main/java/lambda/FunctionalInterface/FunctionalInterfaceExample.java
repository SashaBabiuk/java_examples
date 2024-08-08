package lambda.FunctionalInterface;



import java.util.Arrays;
import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

//Інтефейс consumer має метод accept і він приймає на вхід значення з яким він шось робить (T) -> ()
        Consumer<Person> personConsumer = person -> System.out.println(person.toString());
        Arrays.stream(people).forEach(personConsumer);

//Інтерфейс протилежний до supplier нічо не получає але шось вертає () -> T містить метод get
        Supplier<Person> personSupplier = () -> new Person("Diana", 40);
        Person Diana = personSupplier.get();

//інтерфейс Function приймає значення і вертає інше значення T -> R
        Function<Person,Integer> personIntegerFunction = person -> person.age;
        Arrays.stream(people).map(personIntegerFunction).forEach(System.out::println);

//Predicate інтерфейс використовується для перевірки певних полів приймає T а вертає boolean (T) -> boolean
        Predicate<Person> personPredicate = person ->  person.age > 30;
        Arrays.stream(people).filter(personPredicate).forEach(System.out::println);
//Interface runnable нічого не приймає і нічого не повертає в ньому тільки метод run () -> ()
        Runnable runnable = () -> System.out.println("dsfdgf");

//похожий до Function але приймати і повертає один і той самий тип T -> T
        UnaryOperator<Person> unaryOperator = Person::new;
        Person sasha = unaryOperator.apply(people[0]);
    }
}
