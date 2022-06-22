import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    private static final Set<Integer> ALLOWED_NUMBERS = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static Set<Integer> getSetFromString(String str) {
        return Arrays.stream(str.split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.retainAll(ALLOWED_NUMBERS);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}