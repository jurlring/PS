import java.util.*;
class Solution {
	static Map<Character,Integer> map=new HashMap<>();
	static int [] a={0,1,0,-1};//x축
	static int [] b={1,0,-1,0};//y축
	static int sum=0;
	static char[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int r=s.nextInt();
		int c=s.nextInt();
		String [] alpabet=new String[r];
		visit=new boolean[r][c];
		arr=new char[r][c];
		for(int i=0;i<r;i++){
			alpabet[i]=s.next();
			for(int j=0;j<alpabet[i].length();j++){
				arr[i][j]=alpabet[i].charAt(j);
			}
		}
		dfs(alpabet,0,0,0);
		System.out.println(sum);
	}
	public static void dfs(String[] alpabet,int i, int j,int count) {
		if (map.containsKey(arr[i][j])){
			if (count>sum)
				sum=count;
			return;
		}
		map.put(arr[i][j],i);
		for(int k=0;k<4;k++){
			int x=i+a[k],y=j+b[k];
			if (x>=0&&x<alpabet.length&&y>=0&&y<alpabet[0].length()){
				dfs(alpabet, x, y,count+1);
			}
		}
		map.remove(arr[i][j]);
	}
}