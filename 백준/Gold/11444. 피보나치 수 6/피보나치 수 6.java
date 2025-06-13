import java.io.*;

public class Main {
    static final long MOD = 1000000007; // 나머지 연산을 위한 값

    // 행렬 곱셈 함수 (두 행렬을 곱하고 나머지를 1000000007로 구함)
    public static long[][] matMul(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    // 행렬 거듭제곱 함수
    public static long[][] matPow(long[][] A, long exp) {
        long[][] result = {{1, 0}, {0, 1}}; // 항등 행렬
        long[][] base = A;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = matMul(result, base);
            }
            base = matMul(base, base);
            exp /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // 기본 행렬
        long[][] F = {{1, 1}, {1, 0}};

        // n-1 번째 행렬을 구해야 함
        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }

        // n-1 번째 행렬 계산
        long[][] result = matPow(F, n - 1);

        // F(n) = result[0][0] * F(1) + result[0][1] * F(0) = result[0][0] * 1 + result[0][1] * 0
        System.out.println(result[0][0]);
    }
}
