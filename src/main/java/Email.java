import com.google.common.base.Preconditions;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-12-09.
 */
@Value
public class Email {
    String email;

    private Email(String email) {
        this.email = email;
    }

    public static Email of(@NonNull String email) {
        RegExPattern emailPattern = RegExPattern.EMAIL;
        
        Preconditions.checkArgument(emailPattern.validator.test(email),
                email + " is invalid email: " + emailPattern.message);

        return new Email(email);
    }
}
