import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = -1, B = -1;

        // A 찾기
        for (int i = 1; i <= 9; i++) {
            System.out.println("? A " + i);
            System.out.flush(); // 꼭 flush해줘야 함!
            int response = sc.nextInt();
            if (response == 1) {
                A = i;
                break;
            }
        }

        // B 찾기
        for (int i = 1; i <= 9; i++) {
            System.out.println("? B " + i);
            System.out.flush(); // 꼭 flush해줘야 함!
            int response = sc.nextInt();
            if (response == 1) {
                B = i;
                break;
            }
        }

        // 결과 출력
        System.out.println("! " + (A + B));
        System.out.flush(); // 출력도 꼭 flush!
    }
}
