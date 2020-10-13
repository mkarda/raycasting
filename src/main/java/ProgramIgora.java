import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ProgramIgora {

    private static final List<String> row1 = new ArrayList<>(Arrays.asList("-", "-", "-"));
    private static final List<String> row2 = new ArrayList<>(Arrays.asList("-", "-", "-"));
    private static final List<String> row3 = new ArrayList<>(Arrays.asList("-", "-", "-"));

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);


        boolean isFinished = false;
        printGame();

        while (!isFinished) {
            System.out.println("gdzie postawic krzyżyk");
            String input = scanner.next();
            String row = String.valueOf(input.charAt(0));
            int column = Integer.parseInt(input.substring(1, 2));

            switch (row.toLowerCase()) {
                case "a":
                    row1.set(column - 1, "x");
                    break;
                case "b":
                    row2.set(column - 1, "x");
                    break;
                case "c":
                    row3.set(column - 1, "x");
                    break;
                default:
                    System.out.println("zła pozycja. sprobuj jeszcze raz!!!");
                    break;
            }
            isFinished = checkGame();
            if (isFinished) {
                System.out.println("Wygrał Igor");
            } else {
                compMove();
                isFinished = checkGame();
                if (isFinished) System.out.println("Wygrał Komputer");
            }
            printGame();
        }
    }

    private static void compMove() {
        Random random = new Random();
        int i = random.nextInt(3);
        if (i == 0) {
            placeO(random, row1);
        } else if (i == 1) {
            placeO(random, row2);
        } else if (i == 2) {
            placeO(random, row3);
        }
    }

    private static void placeO(Random random, List<String> row) {
        int i1 = random.nextInt(3);
        String s = row.get(i1);
        if (s.equals("-")) {
            row.set(i1, "o");
        } else {
            compMove();
        }
    }

    private static boolean checkGame() {
        return checkRow(row1) || checkRow(row2) || checkRow(row3) || checkColumn(0) || checkColumn(1) || checkColumn(2) || checkDiagonal();
    }

    private static boolean checkDiagonal() {
        return row1.get(0).equals(row2.get(1)) && row1.get(0).equals(row3.get(2)) && !row1.get(0).equals("-") ||
                row1.get(2).equals(row2.get(1)) && row1.get(2).equals(row3.get(0)) && !row1.get(2).equals("-")
                ;
    }

    private static boolean checkColumn(int col) {
        String s1 = row1.get(col);
        String s2 = row2.get(col);
        String s3 = row3.get(col);
        return s1.equals(s2) && s1.equals(s3) && !s1.equals("-");
    }

    private static boolean checkRow(List<String> row) {
        List<String> collect = row.stream().distinct().collect(Collectors.toList());
        return collect.size() == 1 && !collect.get(0).equals("-");
    }

    private static void printGame() {
        System.out.printf("%s %s %s%n", row1.get(0), row1.get(1), row1.get(2));
        System.out.printf("%s %s %s%n", row2.get(0), row2.get(1), row2.get(2));
        System.out.printf("%s %s %s%n", row3.get(0), row3.get(1), row3.get(2));
    }
}
