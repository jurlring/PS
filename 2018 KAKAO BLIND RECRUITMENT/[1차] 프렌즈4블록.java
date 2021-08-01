import java.util.*;

class code {
	static boolean[][]v;
	static int solution(int m, int n, String[] board) {
		int answer=0;
		v=new boolean[m][n];
		char [][] p=new char[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				p[i][j]=board[i].charAt(j);
			}
		}
		if (answer==0){

		}
		while(true){
			int ans=boom(p);
			if (ans==0)
				break;
			answer+=ans;
			pop(p);
		}

		return answer;
	}
	static void pop(char[][] p){//블럭 터트리기
		for(int i=0;i<p[0].length;i++){
			for(int j=p.length-1;j>=0;j--){
				if (p[j][i]==' '){
					int count=0;
					while(j>=0){
						if (p[j][i]!=' ')
							break;
						count++;
						j--;
					}
					if (j<0)
						break;
					p[j+count][i]=p[j][i];
					p[j][i]=' ';
					j+=count;
				}
			}
		}
	}
	static int boom(char[][] p){//터트릴 블럭 찾기
		for(int i=0;i<p.length-1;i++){
			for(int j=0;j<p[0].length-1;j++){
				if (p[i][j]!=' '&&p[i][j]==p[i][j+1]&&
				p[i][j]==p[i+1][j]&&
				p[i][j]==p[i+1][j+1]){
					v[i][j]=true;
					v[i][j+1]=true;
					v[i+1][j]=true;
					v[i+1][j+1]=true;
				}
			}
		}
		int num=0;
		for(int i=0;i<p.length;i++){
			for(int j=0;j<p[0].length;j++){
				if (v[i][j]){
					num++;
					p[i][j]=' ';
					v[i][j]=false;
				}
			}
		}
		return num;
	}
	//좀 멍청하게 했다고 생각했는데 이게 최선인거 같기도
	public static void main(String[] args) {
		String [] t={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4,5,t));
    }
}