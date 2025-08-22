import user.value.Name;

public class Main {

    public static void main(String[] args) {
        validateName("");
        validateName("DOn131");
        validateName("Don__,Juan");
        validateName("DON Juan");
        validateName("DON    JUAN");


    }

    public static void validateName(String string) {
        try {
            Name name = new Name(string);
            System.out.println(name.getValue());

        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
