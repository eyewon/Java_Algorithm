import java.io.*;
import java.util.*;

class Main {
	static StringBuilder sb; 
	
	public static void postOrder(List<Integer> preOrder, int start, int end) {
		if(start > end) return;
		
		int root = preOrder.get(start);
		int rightStart = start + 1;
		
		//오른쪽 서브트리 시작 인덱스
		while(rightStart <= end && preOrder.get(rightStart) < root) {
			rightStart++;
		}
		
		//왼쪽 서브트리 순회
		postOrder(preOrder, start+1, rightStart-1);
		
		//오른쪽 서브트리 순회
		postOrder(preOrder, rightStart, end);
		
		//루트 순회
		sb.append(root).append("\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> preOrder = new ArrayList<>();
		String input;
		while((input = br.readLine())!=null) {
			preOrder.add(Integer.parseInt(input));
		}
		
		sb = new StringBuilder();
		postOrder(preOrder, 0, preOrder.size()-1);
		System.out.println(sb);
	}

}