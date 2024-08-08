package lambda;

public class Example2 {
    public static void main(String[] args) {
        StringCombiner stringCombiner = (str1, str2) ->
                str1.length() >= str2.length() ? str1 : str2;

        System.out.println(stringCombiner.combine("fdsfd", "sdfgfh"));
    }
}

@FunctionalInterface
interface StringCombiner {
    String combine(String str1, String str2);
}
