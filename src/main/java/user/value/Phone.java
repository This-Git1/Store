package user.value;

final public class Phone extends ValueObject<String> {
    private static final String PHONE_REGEX_RUSSIA = "^((+7|7|8)+([0-9]){10})$";

    //TODO
    public Phone(String value) {
        super(value);
        validateNotEmpty(value);
        validateFormat(normalize(value));
    }

    private static void validateNotEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("поле не может быть пустым");
        }
    }

    private static String normalize(String value) {
        return value.trim().toLowerCase();
    }

    private static void validateFormat(String trimmed) {
        if (!trimmed.matches(PHONE_REGEX_RUSSIA)) {
            throw new IllegalArgumentException("Неверный формат номера");
        }
    }


}
