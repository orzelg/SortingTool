package sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Counter {

    public static void test(String[] args) {
        Long sum = 0l;
        try {
            Scanner scanner = new Scanner(Path.of("/Users/go/Downloads/dataset_91033.txt"));
            while (scanner.hasNextLine()) {
                sum += Long.parseLong(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fw = new FileWriter("/Users/go/Downloads/out.txt")) {
            System.out.println(sum);
            fw.write(sum.toString());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
