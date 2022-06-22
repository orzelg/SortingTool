import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        long square = 1;
        int index = 1;
        if (input > 0) {
            while (square <= input) {
                System.out.println(square);
                square = ++index * index;
            }
        }
    }
}