import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        checkIfAnagrams(word1, word2);
    }

    private static void checkIfAnagrams(String word1, String word2) {
        Map<String, Integer> word1Counters = getCounters(word1);
        Map<String, Integer> word2Counters = getCounters(word2);
        if (word1Counters.equals(word2Counters)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static Map<String, Integer> getCounters(String word) {
        HashMap<String, Integer> counters = new HashMap<>();
        if (word != null && !word.isEmpty()) {
            for (Character c: word.toCharArray()) {
                String key = String.valueOf(c).toUpperCase();
                Integer counter = counters.putIfAbsent(key, 1);
                if (counter != null) {
                    counters.put(key, ++counter);
                }
            }
        }
        return counters;
    }
}