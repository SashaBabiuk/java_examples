package Serialization.ExampleWithStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import Serialization.*;

public class Example {
    public static void main(String[] args) throws IOException {
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        Person renat = new Person("Renat", 2, "Raphael", home);

        String relativePath = "ExampleWithStream/person.bat";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(relativePath));
        objectOutputStream.writeObject(igor);
        objectOutputStream.close();

    }
}
