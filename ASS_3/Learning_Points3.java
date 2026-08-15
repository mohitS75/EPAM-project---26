import java.util.Scanner;

public class Learning_Points3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of topics
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read learning points
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = scanner.nextInt();
        }

        // Handle small cases
        if (n == 1) {
            System.out.println(points[0]);
        } else {
            // dp[i] = maximum points possible from topics 0 to i
            int[] dp = new int[n];

            // First topic
            dp[0] = points[0];

            // Between first and second topic, choose the one with greater points
            dp[1] = Math.max(points[0], points[1]);

            // Fill DP table
            for (int i = 2; i < n; i++) {
                // Option 1: Skip current topic
                int skip = dp[i - 1];

                // Option 2: Take current topic
                int take = dp[i - 2] + points[i];

                dp[i] = Math.max(skip, take);
            }

            // Final answer
            System.out.println(dp[n - 1]);
        }

        scanner.close();
    }
}