import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정답의 길이
        String alphabet = sc.next(); // 정답을 구성하는 알파벳들
        sc.close();

        StringBuilder sb = new StringBuilder();

        // 정답의 각 알파벳을 N번 반복
        for (int i = 0; i < N; i++) {
            sb.append(alphabet);
        }

        System.out.println(sb.toString());
    }
}
