package examples;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

@FunctionalInterface
public interface SequentialIdGenerator extends Iterator<BigInteger> {

    @Override
    public default boolean hasNext() {
        return true;
    }

    public default String nextAsString() {
        return next().toString();
    }

    public default long nextAsLong() {
        return next().longValue();
    }

    public default int nextAsInt() {
        return next().intValue();
    }

    public default BigDecimal nextAsBigDecimal() {
        return new BigDecimal(next());
    }

}
