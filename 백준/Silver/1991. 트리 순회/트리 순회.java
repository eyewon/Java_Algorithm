import java.io.*;
import java.util.*;

class Main {
	static Node[] tree;
	static int[] dist;
	static boolean[] visited;
	static StringBuilder sb;

	static class Node{
		char left, right;
		
		Node(char left, char right){
			this.left = left;
			this.right = right;
		}
	}
	
	public static void preorder(char root) {
		if(root == '.') return;
		sb.append(root);
		preorder(tree[root-'A'].left);
		preorder(tree[root-'A'].right);
	}
	
	public static void inorder(char root) {
		if(root == '.') return;
		inorder(tree[root-'A'].left);
		sb.append(root);
		inorder(tree[root-'A'].right);
	}
	
	public static void postorder(char root) {
		if(root == '.') return;
		postorder(tree[root-'A'].left);
		postorder(tree[root-'A'].right);
		sb.append(root);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[26];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			char node = input[0].charAt(0);
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);
			tree[node-'A'] = new Node(left, right);
		}
		
		sb = new StringBuilder();
		preorder('A');
		sb.append("\n");
		inorder('A');
		sb.append("\n");
		postorder('A');
		
		System.out.println(sb);
	}

}