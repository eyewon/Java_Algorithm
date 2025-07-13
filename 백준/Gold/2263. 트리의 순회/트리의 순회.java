import java.io.*;
import java.util.*;

class Main {
	static int[] inOrder;
	static int[] postOrder;
	static Map<Integer, Integer> inOrderIdx;
	static StringBuilder sb; 
	
	public static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart  > inEnd || postStart > postEnd) return;
		
		int root = postOrder[postEnd];
		int rootIdx = inOrderIdx.get(root);
		
		sb.append(root).append(" "); // 루트 순회 
		
		preOrder(inStart, rootIdx-1, postStart, postStart + (rootIdx-1 -inStart)); // 왼쪽 서브트리 순회
		preOrder(rootIdx+1, inEnd, postStart + (rootIdx -inStart), postEnd-1); // 오른쪽 서브트리 순회 
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		inOrderIdx = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderIdx.put(inOrder[i], i);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) postOrder[i] = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder(); 
		preOrder(0, N-1, 0, N-1);
		System.out.println(sb);
	}

}