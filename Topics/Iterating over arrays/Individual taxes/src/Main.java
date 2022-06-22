import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCompanies = scanner.nextInt();
        double[] incomes = new double[numOfCompanies];
        double max = 0;
        int index = 0;
        for (int i = 0; i < numOfCompanies; i++) {
            incomes[i] = scanner.nextDouble();
        }
        for (int i = 0; i < numOfCompanies; i++) {
            double tax = scanner.nextDouble();
            double taxValue;
            if (tax > 0) {
                taxValue = incomes[i] * tax / 100;
            } else {
                taxValue = 0;
            }
            if (taxValue > max) {
                max = taxValue;
                index = i;
            }
        }
        System.out.println(index + 1);
    }
}