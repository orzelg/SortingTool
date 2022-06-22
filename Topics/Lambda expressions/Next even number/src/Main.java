import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = x -> {
        if (x % 2 > 0) {
            return x + 1;
        } else {
            return x + 2;
        }
    };
}