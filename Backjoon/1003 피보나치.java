import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static Integer [][] fibo=new Integer[41][2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		fibo[0][0]=fibo[1][1]=1;
		fibo[0][1]=fibo[1][0]=0;
		for(int i=0;i<N;i++){
			int f=Integer.parseInt(br.readLine());
			Integer [] arr=fibonacci(f);
			sb.append(arr[0]+" "+arr[1]+"\n");
		}
		System.out.println(sb);
        br.close();
    }
	static Integer[] fibonacci(int n){
		if (fibo[n][0]==null||fibo[n][1]==null){
			fibo[n][0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
			fibo[n][1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
		}
		return fibo[n];

	}
 
}