package user.value;

final public class Name extends ValueObject<String> {
    private static final String NAME_REGEX = "[a-zA-Zа-яА-ЯёЁ\\- ]+";
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 255;

    //TODO
    public Name(String value) {
        super(normalize(value));

        validateNotEmpty(value);
        validateLength(value);
        validateFormat(value);
    }

    private static void validateNotEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    private static void validateLength(String value) {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            String message = String.format("Имя должно содержать от %d до %d символов", MIN_LENGTH, MAX_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateFormat(String value) {
        if (!value.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("Имя может содержать только буквы, пробел и дефис");
        }
    }

    //TODO
    private static String normalize(String value) {
        String trimmed = value.trim().replaceAll(" +", " ");
        return trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase();
    }


}
