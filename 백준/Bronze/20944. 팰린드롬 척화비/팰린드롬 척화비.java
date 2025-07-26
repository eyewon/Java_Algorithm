import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 항상 같은 문자 반복하면 수미상관 + 팰린드롬이 됨 (ex. aaaa...)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append('a');  // a, b, c 등 소문자 중 아무거나 가능
        }

        System.out.println(sb.toString());
    }
}
