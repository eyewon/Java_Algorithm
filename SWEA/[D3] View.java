/*
 * [문제] https://swexpertacademy.com/main/code/problem/problemDetail.do
 * - 양 옆 2칸 이내의 건물보다 현재 건물이 더 높은 경우에만 조망권 확보 가능.
 * - 좌우 각각 두 칸씩 떨어진 위치의 건물 중 가장 높은 높이를 구함.
 * - 현재 건물 높이에서 가장 높은 건물 높이를 뺀 값이 조망이 확보되는 세대 수.
 * - 이 값을 누적하여 전체 조망 확보 세대 수를 계산함.
 * - 양쪽 끝 2칸은 비교 대상이 부족하므로 제외 (범위: index 2 ~ n-3).
 */

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		

		for(int i = 0; i < 10; i++)
		{
            int sol = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = sc.nextInt();
            }
			for(int k=2; k<n-2; k++) {
                int current = arr[k];
                int high = Math.max(Math.max(arr[k-1], arr[k-2]), Math.max(arr[k+1], arr[k+2]));
                if(current > high) {
                    sol+= current-high;
                }
            }
      
            System.out.println("#"+(i+1)+" "+sol);
            
		}
	}
}
