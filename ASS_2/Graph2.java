import java.util.*;

public class Graph2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        distance[1] = 0;

        int answer = 0;

        while (!q.isEmpty()) {

            int city = q.remove();

            if (distance[city] <= d) {
                answer++;
            }

            for (int next : graph.get(city)) {

                if (distance[next] == -1) {

                    distance[next] = distance[city] + 1;

                    q.add(next);
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}