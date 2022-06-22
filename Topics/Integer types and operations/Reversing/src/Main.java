import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        StringBuffer buffer = new StringBuffer();
        buffer.append(input);
        int result = Integer.parseInt(buffer.reverse().toString());
        System.out.println(result);
    }
}