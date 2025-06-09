import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            input[i] = br.readLine();
        }

        int base = -1;

        // 숫자가 포함된 줄이 있으면 해당 줄을 기준으로 인덱스 추정
        for (int i = 0; i < 3; i++) {
            if (isNumeric(input[i])) {
                base = Integer.parseInt(input[i]) - i;
                break;
            }
        }

        // base가 잡혔으면, getFizzBuzz(base + 3)만 구하면 된다!
        System.out.println(getFizzBuzz(base + 3));
    }

    static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    static String getFizzBuzz(int n) {
        if (n % 15 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";
        return Integer.toString(n);
    }
}
