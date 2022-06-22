package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static final String DATA_TYPE_PARAMETER_NAME = "-dataType";
    public static final String SORTING_TYPE_PARAMETER_NAME = "-sortingType";
    public static final String INPUT_FILE_PARAMETER_NAME = "-inputFile";
    public static final String OUTPUT_FILE_PARAMETER_NAME = "-outputFile";
    public static final String NATURAL_SORTING_TYPE_VALUE = "natural";
    public static final String BY_COUNT_SORTING_TYPE_VALUE = "byCount";
    public static final String LONG_VALUE = "long";
    public static final String WORD_VALUE = "word";
    public static final String LINE_VALUE = "line";

    private static final String NO_SORTING_TYPE_MSG = "No sorting type defined!";
    private static final String NO_DATA_TYPE_MSG = "No data type defined!";
    private static final String NOT_VALID_PARAMETER_MSG = "\\\"%s\\\" is not a valid parameter. It will be skipped.";

    public static void main(final String[] args) {
        String dataType = WORD_VALUE;
        String sortingType = NATURAL_SORTING_TYPE_VALUE;
        String inputFilePath = null;
        String outputFilePath = null;
        FileWriter outputFile = null;
        Scanner scanner = null;

        for (int i = 0; i < args.length; i++) {
            if (SORTING_TYPE_PARAMETER_NAME.equals(args[i])) {
                if (args.length > i + 1 && BY_COUNT_SORTING_TYPE_VALUE.equals(args[i + 1])) {
                    sortingType = BY_COUNT_SORTING_TYPE_VALUE;
                    i++;
                } else if (args.length > i + 1 && NATURAL_SORTING_TYPE_VALUE.equals((args[i + 1]))) {
                    sortingType = NATURAL_SORTING_TYPE_VALUE;
                    i++;
                } else {
                    System.out.println(NO_SORTING_TYPE_MSG);
                }
            } else if (DATA_TYPE_PARAMETER_NAME.equals(args[i])) {
                if (args.length > i + 1 && LONG_VALUE.equals(args[i + 1])) {
                    dataType = LONG_VALUE;
                    i++;
                } else if (args.length > i + 1 && LINE_VALUE.equals(args[i + 1])) {
                    dataType = LINE_VALUE;
                    i++;
                } else if (args.length > i + 1 && WORD_VALUE.equals(args[i + 1])) {
                    dataType = WORD_VALUE;
                    i++;
                } else {
                    System.out.println(NO_DATA_TYPE_MSG);
                }
            } else if (INPUT_FILE_PARAMETER_NAME.equals(args[i])) {
                if (args.length > i + 1 && !args[i + 1].isEmpty()) {
                    inputFilePath = args[i + 1];
                    i++;
                }
            } else if (OUTPUT_FILE_PARAMETER_NAME.equals(args[i])) {
                if (args.length > i + 1 && !args[i + 1].isEmpty()) {
                    outputFilePath = args[i + 1];
                    i++;
                }
            } else {
                System.out.printf(NOT_VALID_PARAMETER_MSG, args[i]);
            }
        }

        if (inputFilePath != null && !inputFilePath.isEmpty()) {
            try {
                scanner = new Scanner(new File(inputFilePath));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            scanner = new Scanner(System.in);
        }

        if (outputFilePath != null && !outputFilePath.isEmpty()) {
            try {
                outputFile = new FileWriter(new File(outputFilePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        switch (dataType) {
            case LONG_VALUE:
                processLong(scanner, sortingType, outputFile);
                break;
            case LINE_VALUE:
                processLine(scanner, sortingType, outputFile);
                break;
            default:
                processWord(scanner, sortingType, outputFile);
                break;
        }

        try {
            if (scanner != null) {
                scanner.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getAsString(List data) {
        StringBuilder sb = new StringBuilder();
        for (Object o : data) {
            sb.append(o.toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    private static Object getAsLines(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void print(FileWriter outputFile, String text) {
        if (outputFile != null) {
            try {
                outputFile.write(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(text);
        }
    }

    private static void processLong(Scanner scanner, String sortingType, FileWriter outputFile) {
        List<Long> values = new ArrayList<>();

        while (scanner.hasNextLong()) {
            values.add(scanner.nextLong());
        }

        print(outputFile, String.format("Total numbers: %d.", values.size()));

        if (NATURAL_SORTING_TYPE_VALUE.equals(sortingType)) {
            Collections.sort(values);
            System.out.printf("Sorted data: %s", getAsString(values));
        } else {
            Map<Long, Integer> counts = new HashMap<>();
            for (Long l : values) {
                Integer prev = counts.getOrDefault(l, 0);
                counts.put(l, ++prev);
            }
            Comparator<Map.Entry<Long, Integer>> c = new Comparator<Map.Entry<Long, Integer>>() {
                @Override
                public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                    int valueComparisonResult = Integer.compare(o1.getValue(), o2.getValue());
                    if (valueComparisonResult != 0) {
                        return valueComparisonResult;
                    } else {
                        return Long.compare(o1.getKey(), o2.getKey());
                    }
                }
            };
            Set<Map.Entry<Long, Integer>> sortedEntries = counts.entrySet();
            sortedEntries.stream().sorted(c).forEach((e) -> print(outputFile, String.format("%d: %d time(s), %d%%", e.getKey(), e.getValue(), e.getValue() * 100 / values.size())));
        }
    }

    private static void processLine(Scanner scanner, String sortingType, FileWriter outputFile) {
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        print(outputFile, String.format("Total lines: %d.", lines.size()));

        if (NATURAL_SORTING_TYPE_VALUE.equals(sortingType)) {
            Collections.sort(lines);
            print(outputFile, String.format("Sorted data:\n%s", getAsLines(lines)));
        } else {
            Map<String, Integer> counts = new HashMap<>();
            for (String line : lines) {
                Integer prev = counts.getOrDefault(line, 0);
                counts.put(line, ++prev);
            }
            Comparator<Map.Entry<String, Integer>> c = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int valueComparisonResult = Integer.compare(o1.getValue(), o2.getValue());
                    if (valueComparisonResult != 0) {
                        return valueComparisonResult;
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            };
            Set<Map.Entry<String, Integer>> sortedEntries = counts.entrySet();
            sortedEntries.stream().sorted(c).forEach((e) -> print(outputFile, String.format("%s: %d time(s), %d%%", e.getKey(), e.getValue(), e.getValue() * 100 / lines.size())));
        }

    }

    private static void processWord(Scanner scanner, String sortingType, FileWriter outputFile) {

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        print(outputFile, String.format("Total words: %d.", words.size()));

        if (NATURAL_SORTING_TYPE_VALUE.equals(sortingType)) {
            Collections.sort(words);
            print(outputFile, String.format("Sorted data: %s", getAsString(words)));
        } else {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : words) {
                Integer prev = counts.getOrDefault(word, 0);
                counts.put(word, ++prev);
            }
            Comparator<Map.Entry<String, Integer>> c = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int valueComparisonResult = Integer.compare(o1.getValue(), o2.getValue());
                    if (valueComparisonResult != 0) {
                        return valueComparisonResult;
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            };
            Set<Map.Entry<String, Integer>> sortedEntries = counts.entrySet();
            sortedEntries.stream().sorted(c).forEach((e) -> print(outputFile, String.format("%s: %d time(s), %d%%", e.getKey(), e.getValue(), e.getValue() * 100 / words.size())));
        }
    }

}

