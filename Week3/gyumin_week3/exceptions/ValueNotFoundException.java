package gyumin_week3.exceptions;

public class ValueNotFoundException extends RuntimeException{
    public ValueNotFoundException () {
        super("값 없음");
    }
}
