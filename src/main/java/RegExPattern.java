import lombok.NonNull;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created by mtumilowicz on 2019-01-24.
 */
enum RegExPattern {
    EMAIL("[\\w._]+@[\\w.]+\\.[\\w]{2,}", "It is not a proper email."),
    POSTAL_CODE("\\d{2}-\\d{3}", "Postal code pattern: XX-XXX, where X is a digit."),
    WORD("[\\w]+", "Word could contain only letters, numbers and underscores.");

    public final String message;
    public final Predicate<String> pattern;

    RegExPattern(@NonNull String pattern, @NonNull String message) {
        this.message = message;
        this.pattern = Pattern.compile(pattern).asMatchPredicate();
    }
}
