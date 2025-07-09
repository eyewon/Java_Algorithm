import java.io.*;
import java.util.*;

public class Main {
    static int N, W;
    static Point[] events;
    static int[][] dp;
    static int[][] path;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 거리 계산: 맨해튼 거리
    static int dist(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    // 경찰차가 i, j 번째 사건까지 처리했을 때의 최소 이동 거리
    static int solve(int car1, int car2) {
        if (car1 == W || car2 == W) return 0;

        if (dp[car1][car2] != -1) return dp[car1][car2];

        int next = Math.max(car1, car2) + 1;

        // car1이 next 처리
        int move1 = solve(next, car2) + dist(
            car1 == 0 ? new Point(1, 1) : events[car1],
            events[next]
        );

        // car2가 next 처리
        int move2 = solve(car1, next) + dist(
            car2 == 0 ? new Point(N, N) : events[car2],
            events[next]
        );

        // 더 작은 값을 선택하고, 경로 추적용 path 배열에 기록
        if (move1 < move2) {
            dp[car1][car2] = move1;
            path[car1][car2] = 1;
        } else {
            dp[car1][car2] = move2;
            path[car1][car2] = 2;
        }

        return dp[car1][car2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        events = new Point[W + 1]; // 사건 번호 1~W
        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            events[i] = new Point(x, y);
        }

        dp = new int[W + 1][W + 1];
        path = new int[W + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        StringBuilder sb = new StringBuilder();
        sb.append(solve(0, 0)).append("\n");

        // 경로 추적
        int car1 = 0, car2 = 0;
        for (int i = 0; i < W; i++) {
            int p = path[car1][car2];
            sb.append(p).append("\n");
            if (p == 1) {
                car1 = Math.max(car1, car2) + 1;
            } else {
                car2 = Math.max(car1, car2) + 1;
            }
        }

        System.out.println(sb);
    }
}
