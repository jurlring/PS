
public class Solution {

    static int answer = Integer.MIN_VALUE;
    static int [][] dp;
    public static int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        dp[0][0]=triangle[0][0];
        for(int i=1;i<triangle.length;i++) {
            dp[i][0] = dp[i-1][0]+triangle[i][0];
            for(int j=1;j<=i;j++) {
                dp[i][j] = triangle[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        for(int i=0;i<triangle.length;i++){
            answer=Math.max(answer,dp[triangle.length-1][i]);
        }
        return answer;
    }
    
    public static void main(String[] args) {
        int[][] triangle={{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);

    }

}