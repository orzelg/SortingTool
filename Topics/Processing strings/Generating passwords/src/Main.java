import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String UPPER = "upper";
    private static final String LOWER = "lower";
    private static final String NUMBER = "number";

    private static final List<String> ALL_KEYS = List.of(UPPER, LOWER, NUMBER);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer upperCases = scanner.nextInt();
        Integer lowerCases = scanner.nextInt();
        Integer numbers = scanner.nextInt();
        Integer length = scanner.nextInt();

        Map<String, Integer> criteria = new HashMap<>();
        if (upperCases > 0) {
            criteria.put(UPPER, upperCases);
        }
        if (lowerCases > 0) {
            criteria.put(LOWER, lowerCases);
        }
        if (numbers > 0) {
            criteria.put(NUMBER, numbers);
        }

        Character previous = null;
        StringBuffer result = new StringBuffer();
        while (length > 0) {
            previous = getRandomCharacter(criteria, previous);
            result.append(previous);
            length--;
        }
        System.out.println(result.toString());
    }

    private static Character getRandomCharacter(Map<String, Integer> criteria, Character previous) {
        Character result = null;
        Random rand = new Random();
        List<String> keys = criteria.keySet().stream().collect(Collectors.toList());
        if (!keys.isEmpty()) {
            String randKey = keys.get(rand.nextInt(keys.size()));
            result = randomCharacterByType(randKey, previous);
            Integer counter = criteria.get(randKey);
            if (counter >= 2) {
                criteria.replace(randKey, --counter);
            } else {
                criteria.remove(randKey);
            }
        } else {
            result = randomCharacterByType(ALL_KEYS.get(rand.nextInt(ALL_KEYS.size())), previous);
        }

        return result;
    }

    private static Character randomCharacterByType(String type, Character previous) {
        Character result;
        switch (type) {
            case LOWER:
                result = randomLowerCase(previous);
                break;
            case UPPER:
                result = randomUpperCase(previous);
                break;
            default:
                result = randomDigit(previous);
                break;
        }
        return result;
    }

    private static Character randomLowerCase(Character previous) {
        return randomCharacter(97, 123, previous);
    }

    private static Character randomUpperCase(Character previous) {
        return randomCharacter(65, 91, previous);
    }

    private static Character randomDigit(Character previous) {
        return randomCharacter(48, 58, previous);
    }

    private static Character randomCharacter(int start, int end) {
        Random rand = new Random();
        return Character.valueOf((char) (rand.nextInt(end - start) + start));
    }

    private static Character randomCharacter(int start, int end, Character previous) {
        Character result;
        do {
            result = randomCharacter(start, end);

        } while (result.equals(previous));
        return result;
    }

}