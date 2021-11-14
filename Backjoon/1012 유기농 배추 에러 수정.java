import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
	static int X,Y;
	static int [][]arr;
	static boolean[][] visit;
	static int [] px={-1,1,0,0};
	static int [] py={0,0,-1,1};
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0;i<T;i++){
			X=s.nextInt();
			Y=s.nextInt();
			int K=s.nextInt();
			arr=new int[X][Y];
			visit=new boolean[X][Y];
			for(int j=0;j<K;j++){
				arr[s.nextInt()][s.nextInt()]=1;
			}
			bachu();
		}
        //br.close();
	}
	static void bachu(){
		int count=0;
		for(int i=0;i<X;i++){
			for(int j=0;j<Y;j++){
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
			int a=i+px[k],b=j+py[k];
			if (a>=0&&b>=0&&a<X&&b<Y){
				if (arr[a][b]==1&&!visit[a][b])
					dfs(a,b);
			}
		}
	}
}