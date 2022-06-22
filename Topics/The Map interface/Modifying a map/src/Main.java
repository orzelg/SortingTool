import java.util.*;

class MapUtils {

    private static final String KEY_A = "a";
    private static final String KEY_B = "b";
    private static final String KEY_C = "c";

    public static void mapShare(Map<String, String> map) {
        if (map.containsKey(KEY_A) && map.get(KEY_A) != null) {
            map.put(KEY_B, map.get(KEY_A));
        }
        map.remove(KEY_C);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(":");
            map.put(pair[0], pair[1]);
        }
        MapUtils.mapShare(map);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}