import io.vavr.control.Either;

import static java.util.Objects.isNull;

/**
 * Created by mtumilowicz on 2019-01-24.
 */
public class Doer {
    public Either<String, Y> d(String id) {
        if (isNull(id)) {
            return Either.left(Concept.X.message);
        }
        
        return Either.right(new Y());
    }
}

class Y {
    
}
