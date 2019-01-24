import com.google.common.base.Preconditions;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by mtumilowicz on 2018-12-09.
 */
@Value
public class Word {
    String word;

    private Word(String word) {
        this.word = word;
    }

    public static Word of(@NonNull String word) {
        var wordPattern = RegExPattern.WORD;
        
        Preconditions.checkArgument(wordPattern.validator.test(word),
                word + " is invalid word: " + wordPattern.message);
        
        return new Word(word);
    }
}
