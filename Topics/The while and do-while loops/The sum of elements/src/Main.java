import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int result = 0;
        while (input != 0 && scanner.hasNextInt()) {
            result += input;
            input = scanner.nextInt();
        }
        System.out.println(result);
    }
}