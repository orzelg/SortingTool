import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] words = getInputData();
        boolean result = true;
        if (!wordsAreValid(words)) {
            result = false;
        } else if (words.length == 1) {
            result = true;
        } else {
            for (int i = 1; i < words.length; i++) {
                int stepResult = compare(words[i - 1], words[i]);
                if (stepResult > 0) {
                    result = false;
                    break;
                }
            }
        }
        System.out.print(result);
    }

    private static int compare(String s1, String s2) {
        int compare = s1.compareTo(s2);
        if (compare != 0) return compare / Math.abs(compare);
        return compare;
    }

    private static boolean wordsAreValid(String[] words) {
        if (words == null) return false;
        if (words.length == 0) return false;
        for (String word : words) if (word == null || word.isEmpty()) return false;
        return true;
    }

    private static String[] getInputData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.toLowerCase().split("\\s+");
        return words;
    }
}