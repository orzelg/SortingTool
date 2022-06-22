import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> output = new ArrayList<>();
        List<String> input = List.of(scanner.nextLine().split(" "));

        for (int i = 0; i < input.size(); i++) {
            if (i % 2 != 0) {
                output.add(0, Integer.parseInt(input.get(i)));
            }
        }

        output.forEach(val -> System.out.print(val + " "));
    }
}