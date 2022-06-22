import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input >= 0 && input <= 1000000) {
//            String inputStr = String.valueOf(input);
//            if (inputStr.length() > 1) System.out.println(inputStr.charAt(inputStr.length()-2));
            System.out.println((input/10)%10);
        }
    }
}