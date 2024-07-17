package patterns.composite;

import java.util.ArrayList;
import java.util.List;

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Я круг");
    }
}

class Triangle implements Shape {  // Виправив помилку в назві класу
    @Override
    public void draw() {
        System.out.println("Я трикутник");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Я квадрат");
    }
}

class Composite implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void remove(Shape shape) {
        this.shapes.remove(shape);
    }

    @Override
    public void draw() {
        shapes.forEach(Shape::draw);
    }
}

public class Main {
    public static void main(String[] args) {
        // Створюємо окремі фігури
        Shape circle = new Circle();
        Shape triangle = new Triangle();
        Shape square = new Square();

        // Створюємо композит, який містить окремі фігури
        Composite composite = new Composite();
        composite.add(circle);
        composite.add(triangle);
        composite.add(square);

        // Малюємо всі фігури через композит
        composite.draw();

        // Створюємо ще один композит, який містить перший композит та додаткову фігуру
        Composite composite2 = new Composite();
        composite2.add(composite);
        composite2.add(new Circle());

        // Малюємо всі фігури через новий композит
        composite2.draw();
    }
}
