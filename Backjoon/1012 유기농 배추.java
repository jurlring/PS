import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
	static int [][]arr;
	static boolean[][] visit;
	static int [][] p={{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			int x=s.nextInt();
			int y=s.nextInt();
			int k=s.nextInt();
			arr=new int[x][y];
			visit=new boolean[x][y];
			for(int j=0;j<k;j++){
				arr[s.nextInt()][s.nextInt()]=1;
			}
			bachu(x,y);
		}
        br.close();
	}
	static void bachu(int x,int y){
		int count=0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if (!visit[i][j]&&arr[i][j]==1){
					count++;
					dfs(i,j);
				}
			}
		}
		System.out.println(count);
	}
	static void dfs(int i, int j){
		visit[i][j]=true;
		for(int k=0;k<4;k++){
			int x=i+p[k][0],y=j+p[k][1];

			if (x>=0&&y>=0&&x<arr.length&&y<arr[0].length){
				if (arr[x][y]==1&&!visit[x][y])
					dfs(x,y);
			}
		}
	}
}