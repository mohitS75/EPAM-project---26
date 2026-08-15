import java.util.Arrays;
import java.util.Scanner;

public class Scholarship3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of students and total budget
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        long budget = scanner.nextLong();

        // Read scholarship requirements
        long[] scholarships = new long[n];
        for (int i = 0; i < n; i++) {
            scholarships[i] = scanner.nextLong();
        }

        // Sort from smallest to largest
        Arrays.sort(scholarships);

        // Number of students selected
        int count = 0;

        // Total amount spent
        long total = 0;

        // Select students with minimum scholarship requirements
        for (long amount : scholarships) {
            if (total + amount <= budget) {
                total += amount;
                count++;
            } else {
                break;
            }
        }

        // Print maximum number of students
        System.out.println(count);

        scanner.close();
    }
}