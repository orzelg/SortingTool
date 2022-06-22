import java.util.List;

class Utils {

    public static void sortStrings(List<String> strings) {
        strings.sort((s1, s2) -> {
            return s2.compareTo(s1);
        });
    }
}