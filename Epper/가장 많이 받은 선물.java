// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/258712

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> gift_dict = new HashMap<>();
        int[][] gift_table = new int[n][n];
        int[] gift_score = new int[n];
        int[] total_gift = new int[n];

        for (int i = 0; i < n; ++i) {
            gift_dict.put(friends[i], i);
        }


        for (String gift : gifts) {
            int spaceIndex = gift.indexOf(' ');
            String a = gift.substring(0, spaceIndex);
            String b = gift.substring(spaceIndex + 1);
            int a_index = gift_dict.get(a);
            int b_index = gift_dict.get(b);

            gift_table[a_index][b_index] += 1;

            gift_score[a_index] += 1;
            gift_score[b_index] -= 1;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (gift_table[i][j] > gift_table[j][i]) {
                    total_gift[i] += 1;
                } else if (gift_table[i][j] == gift_table[j][i]) {
                    if (gift_score[i] > gift_score[j]) {
                        total_gift[i] += 1;
                    }
                }
            }
        }
        return Arrays.stream(total_gift).max().getAsInt();
    }
}
