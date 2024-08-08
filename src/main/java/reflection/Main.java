package reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class employeeClass = Class.forName("reflection.Employee");// перший спосіб створення об'єкту
//        Class employeeClass = Employee.class;// другий спосіб створення об'єкту
//        Employee employee = new Employee(); // третій спосіб створення об'єкту
//        Class employeeClass = employee.getClass();

        System.out.println("Class name:" + employeeClass.getSimpleName());
        System.out.println("Packege name:" + employeeClass.getPackageName());
//        Виведення всіх конструкторів
        Constructor constructors[] = employeeClass.getConstructors();
        for(Constructor constructor : constructors)
        {
            System.out.println("Constructor:"+constructor);
        }
//        Виведення всіх методів
        Method methods[] = employeeClass.getDeclaredMethods();
        for (Method method: methods)
        {
            System.out.println("method:"+ method);
        }
        // виведення публічних полів
        Field fields[] = employeeClass.getFields();
        for (Field field: fields)
        {
            System.out.println("Field" + field);
        }
        //виведення всіх полів
        System.out.println("----------------------------");
        Field fieldsFull[] = employeeClass.getDeclaredFields();
        for (Field field: fieldsFull)
        {
            System.out.println("Field" + field);
        }
    }
}
