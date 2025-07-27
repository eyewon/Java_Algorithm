import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] result = new int[N];
        int low = 1;
        int high = N;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
