import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int [][] house=new int [n][3];
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				house[i][j]=s.nextInt();
			}
		}
		for(int i=1;i<n;i++){
			house[i][0]+=Math.min(house[i-1][1], house[i-1][2]);
			house[i][1]+=Math.min(house[i-1][0], house[i-1][2]);
			house[i][2]+=Math.min(house[i-1][0], house[i-1][1]);
		}
		System.out.println(Math.min(Math.min(house[n-1][0], house[n-1][1]), house[n-1][2]));
	}

	
}