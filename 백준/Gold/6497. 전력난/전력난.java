import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parent[rootA] = rootB;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 집 수
            int n = Integer.parseInt(st.nextToken()); // 길 수

            if (m == 0 && n == 0) break;

            List<Edge> edges = new ArrayList<>();
            parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, z));
                totalCost += z;
            }

            Collections.sort(edges);

            int mstCost = 0;
            for (Edge e : edges) {
                if (union(e.from, e.to)) {
                    mstCost += e.weight;
                }
            }

            System.out.println(totalCost - mstCost);
        }
    }
}
