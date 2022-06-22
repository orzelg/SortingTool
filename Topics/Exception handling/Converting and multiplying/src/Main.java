import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    private static final String ZERO = "0";
    private static final String INVALID_USER_INPUT = "Invalid user input: ";
    private static final int MULTIPLIER = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> values = new ArrayList<>();
        String value = "";
        while (scanner.hasNextLine() && !ZERO.equals(value.trim())) {
            value = scanner.nextLine();
            if (!ZERO.equals(value)) {
                values.add(value);
            }
        }
        for (String v: values) {
            try {
                System.out.println(Integer.parseInt(v) * MULTIPLIER);
            } catch (NumberFormatException nfe) {
                System.out.println(INVALID_USER_INPUT + v);
            }
        }
    }
}