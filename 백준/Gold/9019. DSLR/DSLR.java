import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        String ops;

        Node(int num, String ops) {
            this.num = num;
            this.ops = ops;
        }
    }

    static final int MAX = 10000;

    static String bfs(int start, int target) {
        boolean[] visited = new boolean[MAX];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.num == target) {
                return cur.ops;
            }

            int d = (cur.num * 2) % MAX;
            int s = (cur.num == 0) ? 9999 : cur.num - 1;
            int l = (cur.num % 1000) * 10 + (cur.num / 1000);
            int r = (cur.num % 10) * 1000 + (cur.num / 10);

            if (!visited[d]) {
                queue.add(new Node(d, cur.ops + "D"));
                visited[d] = true;
            }
            if (!visited[s]) {
                queue.add(new Node(s, cur.ops + "S"));
                visited[s] = true;
            }
            if (!visited[l]) {
                queue.add(new Node(l, cur.ops + "L"));
                visited[l] = true;
            }
            if (!visited[r]) {
                queue.add(new Node(r, cur.ops + "R"));
                visited[r] = true;
            }
        }

        return ""; // 이론상 도달 못함
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            out.append(bfs(A, B)).append("\n");
        }

        System.out.print(out);
    }
}
