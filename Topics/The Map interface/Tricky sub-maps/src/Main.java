import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        Map<Integer, String> result = new TreeMap<>(Collections.reverseOrder());
        Set<Map.Entry<Integer, String>> entrySet;
        Map.Entry<Integer, String> entry;
        if (map.firstKey() % 2 != 0) {
            entrySet = map.entrySet();
            Map.Entry<Integer, String> firstEntry = entrySet.iterator().next();
            entry = firstEntry;
            Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
            while (iterator.hasNext() && entry.getKey() <= firstEntry.getKey() + 4) {
                result.put(entry.getKey(), entry.getValue());
                entry = iterator.next();
            }
        } else {
            TreeMap<Integer, String> reversedMap = new TreeMap<>(Collections.reverseOrder());
            reversedMap.putAll(map);
            entrySet = reversedMap.entrySet();
            Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
            entry = iterator.next();
            while (iterator.hasNext() && entry.getKey() >= map.lastKey() - 4) {
                result.put(entry.getKey(), entry.getValue());
                entry = iterator.next();
            }
        }
        return result;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}