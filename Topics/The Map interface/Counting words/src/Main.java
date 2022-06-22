import java.util.*;

class MapUtils {

    private static final Integer DEFAULT_VALUE = 0;

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        TreeMap<String, Integer> counters = new TreeMap<>();
        for (String word: strings) {
            var prev = counters.getOrDefault(word, DEFAULT_VALUE);
            counters.put(word, ++prev);
        }
        return counters;
    }

    public static void printMap(Map<String, Integer> map) {
        for (String key: map.keySet()) {
            System.out.printf("%s : %d\n", key, map.get(key));
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}