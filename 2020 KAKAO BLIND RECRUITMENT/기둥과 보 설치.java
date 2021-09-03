import java.util.*;
class Solution {
	static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = new int[build_frame.length][3];
		int [][] struct=new int[n+1][n+1];
		for(int []k:build_frame){
			int x=k[0],y=k[1];
			if (k[2]==0){//기둥인경우
				if (k[3]==1){//설치
					if (y==0){//바닥인경우
						struct[k[1]][x]=1;
					}
					else if (y>0&&struct[y-1][x]==1){//다른 기둥 위
						struct[y][x]=1;
					}
					else if (x>0&&struct[y][x-1]==2){//왼쪽에 보가 있는 경우
						struct[y][x]=1;
					}
					else if (x<=n&&struct[y][x]==2){//오른쪽에 보가 있는 경우
						struct[y][x]=3;//
					}
				}
				if (k[3]==0){//삭제

				}
			}
			if (k[2]==1){//보인경우
				if (k[3]==1){//설치
					if (struct[y-1][x]==1){//왼쪽에 기둥이 있는 경우
						struct[y][x]=3;
					}
					else if (x<=n&&struct[y-1][x]==1){//오른쪽에 기둥이 있는 경우
						struct[y][x]=2;
					}
					else if (x>0&&x<=n&&struct[y][x-1]==2&&struct[y][x+1]==2){//양옆에 보가 있는 경우
						struct[y][x]=2;
					}
				}
				if (k[3]==0){//삭제

				}
			}
		}
		int c=0;
		for(int y=0;y<=n;y++){
			for(int x=0;x<=n;x++){
				if (struct[y][x]==1){
					answer[c][0]=x;
					answer[c][1]=y;
					answer[c++][2]=0;
				}
				else if (struct[y][x]==2){
					answer[c][0]=x;
					answer[c][1]=y;
					answer[c++][2]=1;
				}
				else if (struct[y][x]==3){
					answer[c][0]=x;
					answer[c][1]=y;
					answer[c++][2]=0;
					answer[c][0]=x;
					answer[c][1]=y;
					answer[c][2]=1;
				}
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int [][] k={{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int [][] u=solution(5,k);
		for(int i=0;i<u.length;i++){
			for(int j=0;j<3;j++)
				System.out.print(u[i][j]+" ");
			System.out.println();
		}
	}
}