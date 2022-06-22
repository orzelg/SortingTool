import java.util.Scanner;


class Main {

    private static final String LUCKY = "Lucky";
    private static final String REGULAR = "Regular";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() >= 2) {
            System.out.println(checkSum(input.substring(0, 3), input.substring(input.length() - 3)));
        } else {
            System.out.println(REGULAR);
        }
    }

    private static String checkSum(String substring, String substring1) {
        if (count(substring) == count(substring1)) {
            return LUCKY;
        }
        return REGULAR;
    }

    private static int count(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += Character.getNumericValue(input.charAt(i));
        }
        return result;
    }
}