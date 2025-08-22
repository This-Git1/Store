package user.value;

public abstract class ValueObject<T> {
    private final T value;

    public ValueObject(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value не может быть null");
        }
        this.value = value;
    }

    public T getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> value1 = (ValueObject<?>) o;
        return value.equals(value1.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
