import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int R = Integer.parseInt(st.nextToken()); // 루트 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리 수

        // 인접 리스트 초기화
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // 서브트리 크기 계산
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(R);  // 루트에서 시작

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[query]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int node) {
        visited[node] = true;
        int size = 1;

        for (int next : tree[node]) {
            if (!visited[next]) {
                size += dfs(next);
            }
        }

        subtreeSize[node] = size;
        return size;
    }
}
