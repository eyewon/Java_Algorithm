// 문제: https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] items = new int[n + 1][2]; // 물건의 무게와 가치 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        // 무게 기준으로 정렬
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n + 1][k + 1]; // DP

        // 냅색 알고리즘
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= items[i][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j - items[i][0]] + items[i][1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
