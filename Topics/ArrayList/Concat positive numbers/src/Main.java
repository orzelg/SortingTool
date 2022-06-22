import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

class ConcatPositiveNumbersProblem {

    public static ArrayList<Integer> concatPositiveNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(getPositiveNumbers(l1));
        result.addAll(getPositiveNumbers(l2));
        return result; // write your code here
    }

    private static Collection<Integer> getPositiveNumbers(ArrayList<Integer> inputList) {
        ArrayList<Integer> result = new ArrayList<>();
        if (inputList != null && !inputList.isEmpty()) {
            for (Integer number: inputList) {
                if (number > 0) {
                    result.add(number);
                }
            }
        }
        return result;
    }

    /* Do not modify this method */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatPositiveNumbers(list1, list2);

        result.forEach(n -> System.out.print(n + " "));
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}