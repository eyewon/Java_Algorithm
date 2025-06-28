import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = 200_000_000; // 충분히 큰 값
    static int N, E;
    static List<Node>[] graph;

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c)); // 무방향 그래프
        }

        // 반드시 거쳐야 하는 두 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라 세 번
        int[] from1 = dijkstra(1);
        int[] fromV1 = dijkstra(v1);
        int[] fromV2 = dijkstra(v2);

        // 두 가지 경로 고려
        long route1 = (long) from1[v1] + fromV1[v2] + fromV2[N];
        long route2 = (long) from1[v2] + fromV2[v1] + fromV1[N];

        long answer = Math.min(route1, route2);
        System.out.println(answer >= INF ? -1 : answer);
    }
}