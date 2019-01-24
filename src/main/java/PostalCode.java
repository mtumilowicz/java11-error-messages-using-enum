import com.google.common.base.Preconditions;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-12-09.
 */
@Value
public class PostalCode {
    String postalCode;

    private PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public static PostalCode of(@NonNull String postalCode) {
        var postalCodePattern = RegExPattern.POSTAL_CODE;
        
        Preconditions.checkArgument(postalCodePattern.validator.test(postalCode), 
                postalCode + " is invalid postal code: " + postalCodePattern.message);
        
        return new PostalCode(postalCode);
    }
}
