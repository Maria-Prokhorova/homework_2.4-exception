import java.io.IOException;

public class WrongLoginException extends IOException {
    public WrongLoginException(String message) {
        super(message);
    }
}
