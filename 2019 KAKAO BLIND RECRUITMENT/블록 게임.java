import java.util.*;
class Solution {
    int N;
    int [][] b;
    public int solution(int[][] board) {
        int answer = 0;
        int cnt=1;
        N=board.length;
        b=board;
        while(cnt!=0){
            cnt=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if (i<N-1&&j<N-2&&find(i,j,2,3)){
                        cnt++;
                    }
                    else if (i<N-2&&j<N-1&&find(i,j,3,2)){
                        cnt++;
                    }
                }
            }
            answer+=cnt;
        }
        return answer;
    }
    boolean find(int row,int col,int h,int w){
        int empty=0;
        int last=-1;
        for(int i=row;i<row+h;i++){
            for(int j=col;j<col+w;j++){
                if (b[i][j]==0){
                    if (!fill(i,j)) 
                        return false;
                    if (++empty>2)
                        return false;
                }
                else {
                    if (last!=-1&& last!=b[i][j])
                        return false;
                    last=b[i][j];
                }
            }
        }
        for(int i=row;i<row+h;i++){
            for(int j=col;j<col+w;j++){
                b[i][j]=0;
            }
        }
        return true;
    }
    boolean fill(int r,int c){
        for(int i=0;i<r;i++){
            if (b[i][c]!=0)
                return false;
        }
        return true;
    }
    	public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            int[][] arr={{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
            System.out.println(solution(arr));
            
    }
}