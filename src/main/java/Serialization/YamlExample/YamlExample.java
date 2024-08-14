package Serialization.YamlExample;

import Serialization.Home;
import Serialization.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlExample {
    public static void main(String[] args) throws Exception {
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

        String igorYaml = yamlMapper.writeValueAsString(igor);
        System.out.println(yamlMapper.readValue(igorYaml,Person.class));
    }
}
