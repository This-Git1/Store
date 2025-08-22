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
            throw new IllegalArgumentException("Имя должно содержать от 2 до 50 символов");
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
