package Serialization.JacksonExample;


import Serialization.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonExample {
    public static void main(String[] args) throws Exception {
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        //Person renat = new Person("Renat", 2, "Raphael", home);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String igorJson = objectMapper.writeValueAsString(igor);

        Person person = objectMapper.readValue(igorJson,Person.class);

        System.out.println(person.toString());
    }
}
