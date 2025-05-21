// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;

class Solution {
    static int solution(int[][] board, int[] moves) {
        int answer = 0; // 사라진 인형 개수 카운트
        int height = board.length; // 격자 높이
        int moves_cnt = moves.length; // 크레인 작동 횟수
        Stack<Integer> basket = new Stack<>();

				// 크레인 작동
        for(int i = 0; i < moves_cnt; i++) {
            int pos = moves[i] - 1; // 크레인 작동 위치 (열)

            for(int j = 0; j < height; j++) { // (행; 작을수록 높은 위치)
                if(board[j][pos] == 0) { // 상단에 인형이 없는 경우 -> 아래칸 탐색
                    continue;
                }

								// 인형 집어올리기
                int doll = board[j][pos];
                board[j][pos] = 0;

                if(!basket.empty() && doll == basket.peek()) { // 같은 모양의 인형이 나란히 쌓이는 경우
                    basket.pop(); // basket에서 인형 제거하기
                    answer += 2;
                }
                else { // 다른 모양의 인형이 나란히 쌓이는 경우
                    basket.push(doll); // basket에 인형 쌓기
                }
                break;
            }

        }
        return answer;
    }
		
		// 예제 테스트 할 수 있는 메인 함수
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
				
				// 연산
        int result = solution(board, moves);

				// 출력
        System.out.println(result);
    }
}
