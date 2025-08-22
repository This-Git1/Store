package user.value;

final public class Email extends ValueObject<String> {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";


    //TODO
    public Email(String value) {
        super(value);

        validateNotEmpty(value);
        String trimmed = normalize(value);
        validateFormat(trimmed);
    }

    private static void validateNotEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Email не может быть пустым");
        }
    }

    private static String normalize(String value) {
        return value.trim().toLowerCase();
    }

    private static void validateFormat(String value) {
        if (!value.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Неверный формат Email");
        }
    }


}
