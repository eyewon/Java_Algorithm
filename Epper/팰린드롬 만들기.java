//문제: https://www.acmicpc.net/problem/1213


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static final int SIZE = 26;

    public static ArrayList<Integer> countAlphabet(String text) {
				// text에 있는 각 알파벳의 개수를 세어 리턴하는 함수
        ArrayList<Integer> count = new ArrayList<>(Collections.nCopies(SIZE, 0)); // A-Z까지 문자의 개수를 저장할 리스트

        for (int i = 0; i < text.length(); i++) {
						// 각 문자를 인덱스로 바꿔주기 위해 'A'의 인덱스를 빼줌
            count.set(text.charAt(i) - 'A', count.get(text.charAt(i) - 'A') + 1);
        }

        return count;
    }

    public static String makePalindrome(ArrayList<Integer> count) {
				// 팰린드롬을 만들어 리턴하는 함수
        StringBuilder part1 = new StringBuilder();
        StringBuilder part2 = new StringBuilder();
        StringBuilder part3 = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
						// 만약 알파벳의 수가 홀수라면
            if (count.get(i) % 2 == 1) {
								// 이미 가운데 글자가 찼다면 더 이상 불가능
                if (part2.length() == 1) {
                    return "I'm Sorry Hansoo";
                }
								// 가운데 글자가 비어있다면 할당
                part2.append((char) (i + 'A'));
            }
						// 남은 수의 절반을 나누어 part1과 part3에 이어 붙인다
            for (int j = 0; j < count.get(i) / 2; j++) {
                part1.append((char) (i + 'A'));
                part3.insert(0, (char) (i + 'A'));
            }
        }

        return part1.toString() + part2.toString() + part3.toString();
    }

    public static String solution(String str) {
        ArrayList<Integer> count = countAlphabet(str);
        return makePalindrome(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(solution(input));
    }
}
