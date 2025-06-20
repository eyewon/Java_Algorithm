import java.io.*;
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight; // 무게 기준 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석 무게 기준 오름차순 정렬
        Arrays.sort(jewels);
        // 가방 무게 기준 오름차순 정렬
        Arrays.sort(bags);

        // 최대 힙: 보석 가격 기준 내림차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long totalValue = 0;
        int jewelIdx = 0;

        for (int i = 0; i < K; i++) {
            int bagWeight = bags[i];

            // 현재 가방에 들어갈 수 있는 보석들을 maxHeap에 넣기
            while (jewelIdx < N && jewels[jewelIdx].weight <= bagWeight) {
                maxHeap.offer(jewels[jewelIdx].value);
                jewelIdx++;
            }

            // 현재 가방에 넣을 수 있는 가장 비싼 보석 선택
            if (!maxHeap.isEmpty()) {
                totalValue += maxHeap.poll(); // 가장 비싼 보석 꺼내서 사용
            }
        }

        System.out.println(totalValue);
    }
}
