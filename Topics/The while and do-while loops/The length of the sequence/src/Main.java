import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while(scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input > 0) {
                counter++;
            } else if (input == 0) {
                break;
            }
        }
        System.out.println(counter);
    }
}