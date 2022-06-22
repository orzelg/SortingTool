import java.util.Scanner;

class ManufacturingController {

    private static final String REQUESTED = ". Requested ";

    static int total;

    private ManufacturingController() {
        throw new IllegalStateException("Utility class");
    }

    public static String requestProduct(String product) {
        return ++total + REQUESTED + product;
    }

    public static int getNumberOfProducts() {
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}