package Serialization.XMLExample;

import Serialization.Home;
import Serialization.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new XmlMapper();
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String igorXMl = mapper.writeValueAsString(igor);
        System.out.println(mapper.readValue(igorXMl,Person.class));
    }
}
