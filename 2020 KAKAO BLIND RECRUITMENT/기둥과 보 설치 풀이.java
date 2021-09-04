import java.util.*;
class Solution {
	static boolean[][] bo,col;
	static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
		bo=new boolean[n+3][n+3];
		col=new boolean[n+3][n+3];
		int count=0;
		for(int []i:build_frame){
			int x=i[0]+1,y=i[1]+1;
			if (i[2]==0){//기둥
				if (i[3]==0&&remove(x,y,0,n)){//삭제
					count--;
				}
				else if (i[3]==1&&installcol(x,y)){//설치
					count++;
					col[x][y]=true;
				}
			}
			else if (i[2]==1){//보
				if (i[3]==0&&remove(x,y,1,n)){//삭제
					count--;
				}
				else if (i[3]==1&&installbo(x,y)){//설치
					count++;
					bo[x][y]=true;
				}
			}
		}
		answer=new int[count][3];
		int c=0;
		for(int x=1;x<=n+1;x++){
			for(int y=1;y<=n+1;y++){
				if (col[x][y])
					answer[c++]=new int[]{x-1,y-1,0};
				if (bo[x][y])
					answer[c++]=new int[]{x-1,y-1,1};
			}
		}
        return answer;
    }
	private static boolean remove(int x, int y,int a,int n) {
		if (a==0)
			col[x][y]=false;
		else
			bo[x][y]=false;
		for(int i=1;i<=n+1;i++){
			for(int j=1;j<=n+1;j++){
				if (bo[i][j]&&!installbo(i, j)){
					if (a==0)
						col[x][y]=true;
					else
						bo[x][y]=true;
					return false;
				}
				if (col[i][j]&&!installcol(i, j)){
					if (a==0)
						col[x][y]=true;
					else
						bo[x][y]=true;
					return false;
				}
			}
		}
		return true;
	}
	private static boolean installbo(int x, int y) {
		return col[x][y-1]||col[x+1][y-1]||(bo[x-1][y]&&bo[x+1][y]);
	}

	private static boolean installcol(int x, int y) {
		return y==1||col[x][y-1]||bo[x-1][y]||bo[x][y];
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int [][] k={{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int [][] u=solution(5,k);
		for(int i=0;i<u.length;i++){
			for(int j=0;j<3;j++)
				System.out.print(u[i][j]+" ");
			System.out.println();
		}
	}
}