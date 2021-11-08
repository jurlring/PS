import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int [] arr=new int[9];
		int sum=0,i=0,j=0,a=0,b=0;
		for(i=0;i<9;i++){
			arr[i]=s.nextInt();
			sum+=arr[i];
		}		
		Arrays.sort(arr);
		for(i=0;i<8;i++){
			for(j=i+1;j<9;j++){
				if (sum-arr[i]-arr[j]==100){
					a=arr[i];
					b=arr[j];
					break;
				}
			}
		}
		for(i=0;i<9;i++){
			if (arr[i]==a||arr[i]==b)
				continue;
			System.out.println(arr[i]);
		}
		s.close();	
    }
}