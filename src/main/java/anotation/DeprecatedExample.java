package anotation;

public class DeprecatedExample {
    public void useDeprecatedMethod() {
        oldMethod();
    }

    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated");
    }
}
