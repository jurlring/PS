import java.util.*;
class Solution {
	static int hom=0;
	static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
		int n=lock.length,m=lock.length;
		int [][] locks=new int [n*3][n*3];
		for(int i=0;i<n*3;i++)
			Arrays.fill(locks[i], -1);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				locks[i+n][j+n]=lock[i][j];
				if (lock[i][j]==0)
					hom++;
			}
		}
		for(int i=0;i<n*3;i++){
			for(int j=0;j<n*3;j++){
				if (i+m>n&&j+m>n&&i+m<n*3&&j+m<n*3){
					int [][] keys=key;
					for(int k=0;k<4;k++){
						if (match(locks,keys,i,j))
							return true;
						else
							keys=rotate(keys);

					}
				}
				
			}
		}
        return false;
    }

	private static int [][] rotate(int[][] keys) {
		int n=keys.length;
		int [][] key=new int [n][n];
		for(int y=0;y<n;y++){
			for(int x=0;x<n;x++){
				key[x][n-1-y]=keys[y][x];
			}
		}
		return key;
	}

	private static boolean match(int[][] locks, int[][] keys,int i,int j) {
		int count=0;
		for(int y=0;y<keys.length;y++){
			for(int x=0;x<keys.length;x++){
				//System.out.println(locks[y+j][x+i]+" "+keys[y][x]);
				if (locks[y+j][x+i]==1)  {//자물쇠가 돌기인 경우
					if (keys[y][x]==1){//열쇠가 돌기 인경우-> false, 홈인 경우 넘어가기
						return false;
					}
				}
				if (locks[y+j][x+i]==0&&keys[y][x]==1)
					count++;
			}
		}
		System.out.println(i+" "+j+" "+count);
		if (count==hom)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int [][] key={{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int [][] lock={{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key,lock));
	}
}