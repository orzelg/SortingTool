import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer startIdx = scanner.nextInt();
        Integer endIdex = scanner.nextInt();
        Integer size = scanner.nextInt();
        scanner.nextLine();

        SortedMap<Integer, String> map = new TreeMap();

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            Integer key = Integer.parseInt(tokens[0]);
            String value = tokens[1];
            map.put(key, value);
        }

        map.forEach((key, value) -> {
            if (key >= startIdx && key <= endIdex) {
                System.out.printf("%d %s\n", key, value);
            }
        });

    }
}