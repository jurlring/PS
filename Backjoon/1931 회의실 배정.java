import java.util.Arrays;
import java.util.Scanner;
class Time implements Comparable<Time>{
	int start;
	int end;

	public Time(int s,int e){
		this.start=s;
		this.end=e;
	}

	@Override
	public int compareTo(Time o) {
		if (end-o.end==0){
			return start-o.start;
		}
		return end-o.end;
	}
}
public class Solution {
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);
		int N = s.nextInt();
		Time [] arr=new Time[N];	
		for(int i=0;i<N;i++){
			int start=s.nextInt();
			int end=s.nextInt();
			arr[i]=new Time(start,end);
		}
		Arrays.sort(arr);// end time으로 정렬
		int count=0,time=0;
		for(int i=0;i<N;i++){
			if (time<=arr[i].start){
				count++;
				time=arr[i].end;
				System.out.println(arr[i].start+" "+arr[i].end);
			}
		}
		System.out.println(count);
        //br.close();
	}
}