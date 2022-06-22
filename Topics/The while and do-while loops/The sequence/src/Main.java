import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        Integer cnt = 0;
        Integer maxNumber = 0;
        TreeSet<Integer> numbers = new TreeSet<>(Collections.reverseOrder());
        while (cnt <= size && scanner.hasNextInt()) {
            Integer input = scanner.nextInt();
            if (input > maxNumber && input % 4 == 0) {
                maxNumber = input;
            }
            cnt++;
        }
        System.out.println(maxNumber);
    }
}