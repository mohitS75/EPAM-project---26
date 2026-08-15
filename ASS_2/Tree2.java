import java.util.*;

public class Tree2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] key = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            key[i] = sc.nextInt();
        }

        List<List<Integer>> tree = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] xor = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;
        xor[1] = key[1];

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.remove();

            if (xor[current] >= k) {
                count++;
            }

            for (int next : tree.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    xor[next] = xor[current] ^ key[next];
                    queue.add(next);
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}