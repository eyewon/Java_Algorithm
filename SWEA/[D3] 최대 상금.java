/*
 * [문제] https://swexpertacademy.com/main/code/problem/problemDetail.do
 * - 숫자판에서 두 자리의 숫자를 최대 m번까지 교환하여 만들 수 있는 최대 수를 구하는 문제.
 * - DFS(깊이 우선 탐색)로 모든 교환 조합을 탐색하면서 최댓값을 갱신함.
 * - 중복 상태 방지를 위해 "현재 숫자 상태 + 남은 교환 횟수"를 Set에 저장해 방문 체크함.
 * - 매 교환 후 다시 원래 상태로 되돌리는 백트래킹(backtracking) 필수.
 * - 주의: 테스트케이스마다 visited와 max 초기화 필요!
 */

import java.util.*;

class Solution
{   
    static Set<String> visited;
    static int max;
     
    public static void swap(char[] arr, int i, int j) {
        char temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    private static void change(char[] arr, int cnt, int m) {
         
        if(cnt==m) {
            int val=Integer.parseInt(new String(arr));
            max = Math.max(val, max);
            return;
        }
        String state = new String(arr);
        if(visited.contains(state+cnt)) return;
        visited.add(state+cnt);
         
        for (int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                swap(arr, i, j);
                change(arr, cnt+1, m);
                swap(arr, i, j);
            }
        }
             
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int  T= sc.nextInt();
 
        for(int t = 0; t < T; t++)
        {
            System.out.print("#"+(t+1)+" ");
            String st = sc.next();
            int m = sc.nextInt();
            max=0;
            visited = new HashSet<>();
           change(st.toCharArray(), 0, m);
             
            System.out.println(max);
             
        }
    }
}
