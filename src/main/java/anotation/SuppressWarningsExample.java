package anotation;

import java.io.FileReader;
import java.io.Reader;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked") // без цього копілятор видає попередження про raw(сирі типи) типи
    public static void main(String[] args) {
        List rawList = new ArrayList(); // Використання сирого типу
        rawList.add("String");
        rawList.add("Another String");

        // Використовуємо необроблений тип, тому додаємо @SuppressWarnings("unchecked")
        List<String> stringList = rawList;

        for (String s : stringList) {
            System.out.println(s);
        }
    }
}

@SuppressWarnings("unused") // без цієї анотації ми будемо получати попередження про те, що клас ніде юзається
class UnusedVariableExample {
    public void methodWithUnusedVariable() {
        int unusedVariable = 42; // Ця змінна не використовується

    }
}
