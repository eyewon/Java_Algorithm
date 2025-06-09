import java.io.*;
import java.util.*;

class Main {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            int[] priorities = new int[10];  // 중요도 1~9 저장용 (빈도수)

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
                priorities[priority]++;
            }

            int order = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();

                // current보다 더 높은 중요도가 있는지 확인
                boolean hasHigher = false;
                for (int i = current.priority + 1; i <= 9; i++) {
                    if (priorities[i] > 0) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.offer(current);  // 뒤로 보냄
                } else {
                    order++;  // 인쇄
                    priorities[current.priority]--;
                    if (current.index == M) {
                        System.out.println(order);
                        break;
                    }
                }
            }
        }
    }
}
