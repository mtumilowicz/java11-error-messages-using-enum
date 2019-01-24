import lombok.NonNull;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created by mtumilowicz on 2019-01-24.
 */
enum RegExPattern {
    EMAIL("[\\w.]+@[\\w.]+\\.[\\w]{2,}", "Email pattern: address@prefix.suffix, where:" +
            "address contains letters, numbers, underscores and dots, " +
            "prefix contains letters, numbers, underscores and dots, " +
            "suffix is contains at least 2 letters, numbers and underscores."),
    POSTAL_CODE("\\d{2}-\\d{3}", "Postal code pattern: XX-XXX, where X is a digit."),
    WORD("[\\w]+", "Word could contain only letters, numbers and underscores.");

    public final String message;
    public final Predicate<String> validator;

    RegExPattern(@NonNull String regex, @NonNull String message) {
        this.message = message;
        this.validator = Pattern.compile(regex).asMatchPredicate();
    }
}
