
import org.checkerframework.checker.nullness.qual.*;

public class NonNullError {
    void sample() {
        @NonNull Object ref = null;
    }
}