import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static int findFastestTime(int N, int K) {
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        
        dist[N] = 0;
        dq.addFirst(N);
        
        while (!dq.isEmpty()) {
            int x = dq.pollFirst();
            if (x == K) {
                return dist[x];
            }
            
            // 순간이동 (0초)
            int nx = 2 * x;
            if (nx <= MAX && nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }
            
            // 걷기 (1초)
            int[] moves = {x - 1, x + 1};
            for (int next : moves) {
                if (next >= 0 && next <= MAX && dist[next] == -1) {
                    dist[next] = dist[x] + 1;
                    dq.addLast(next);
                }
            }
        }
        return -1; // 혹시 못찾으면
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(findFastestTime(N, K));
    }
}
