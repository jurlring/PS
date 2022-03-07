
public class Solution {

    static boolean[][] puddle;
    static long[][] dp;
    static int answer=0;
    static final int X_INDEX=0;
    static final int Y_INDEX=1;


    public static int solution(int x, int y, int[][] puddles) {
        dp=new long[y+1][x+1];
        puddle=new boolean[y+1][x+1];
        checkPuddles(puddles);
        dp[1][1]=1;
        for(int i=1;i<=y;i++){
            for(int j=1;j<=x;j++){
                if (i==1&&j==1){
                    continue;
                }
                if (puddle[i][j]){
                    dp[y][x]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j] % 1000000007+dp[i][j-1] % 1000000007;
            }
        }
        return (int)dp[y][x]%1000000007;
    }

    private static void checkPuddles(int[][] puddles) {
        for(int[] p:puddles){
            puddle[p[Y_INDEX]][p[X_INDEX]]=true;
        }
    }

    public static void main(String[] args) {
        int[][] puddles ={{2,2}};
        System.out.println(solution(4,3,puddles));
    }

}