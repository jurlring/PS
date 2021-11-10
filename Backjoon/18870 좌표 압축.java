import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
class Solution {
	public static void main(String[] args) throws IOException {
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int arr[]=new int[N];
		int ar[]=new int[N];
		for(int i=0;i<N;i++){
			arr[i]=s.nextInt();
			ar[i]=arr[i];
		}
		Arrays.sort(ar);

		Map<Integer,Integer> map=new HashMap<>();
		int pivot=ar[0],count=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++){
			if (pivot!=ar[i]){
				count++;
				pivot=ar[i];
			}
			map.put(ar[i],count);
		}
		for(int i=0;i<N;i++){
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
		
		s.close();	
    }
}