import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

class Main{
    public static int solution(int[] times){
        Arrays.sort(times);
        int sum=0;
        int prev=0;
        for(int t: times){
            prev+=t;
            sum+=prev;
            
        }
        return sum;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        
        int times[] = new int[n];
        String input[] = br.readLine().split(" ");
        for(int i=0; i<input.length ; i++){
            times[i]=Integer.parseInt(input[i]);
        }
        
        System.out.print(solution(times));
    }
}