import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] dp = new boolean[31][40001];
    static int[] weight;
    static int N;

    public static void dfs(int idx, int diff) {
        if (idx > N) return;
        if (dp[idx][diff]) return; // 이미 방문

        dp[idx][diff] = true;

        if (idx == N) return;

        int w = weight[idx + 1]; // 1-based

        // 추를 사용하지 않음
        dfs(idx + 1, diff);

        // 추를 오른쪽에 놓음
        if (diff + w <= 40000)
            dfs(idx + 1, diff + w);

        // 추를 왼쪽에 놓음
        int nextDiff = Math.abs(diff - w);
        if (nextDiff <= 40000)
            dfs(idx + 1, nextDiff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        weight = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int bead = Integer.parseInt(st.nextToken());
            if (bead > 40000) {
                sb.append("N ");
            } else {
                sb.append(dp[N][bead] ? "Y " : "N ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
