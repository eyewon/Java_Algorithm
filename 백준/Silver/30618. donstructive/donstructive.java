import java.io.*;
import java.util.*;

public class Main {
    static class IndexWeight implements Comparable<IndexWeight> {
        long weight;
        int index;

        IndexWeight(long weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(IndexWeight o) {
            return Long.compare(o.weight, this.weight); // 내림차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        IndexWeight[] weights = new IndexWeight[N];
        for (int i = 1; i <= N; i++) {
            long weight = (long) i * (N - i + 1); // 오버플로우 방지용 long
            weights[i - 1] = new IndexWeight(weight, i);
        }

        Arrays.sort(weights); // 가중치 내림차순 정렬

        int[] result = new int[N];
        int value = N;
        for (IndexWeight iw : weights) {
            result[iw.index - 1] = value;
            value--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
