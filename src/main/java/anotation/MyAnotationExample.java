package anotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class MyAnotationExample {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        print(person,person.getClass());
    }
    public static void print(Object o, Class c) throws IllegalAccessException, NoSuchFieldException {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations)
            {
                if(annotation.annotationType().equals(show.class))
                {
                    System.out.println(field.get(o));
                }
            }
        }
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface show
{
}

class Person
{
    @show
    String name = "Oleksandr";
    @show
    int age = 19;
}


