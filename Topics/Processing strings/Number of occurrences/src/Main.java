import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String subString = scanner.nextLine();

        int counter = 0;
        while (input.indexOf(subString) >= 0) {
            counter++;
            input = input.substring(input.indexOf(subString) + subString.length());
        }

        System.out.println(counter);
    }
}