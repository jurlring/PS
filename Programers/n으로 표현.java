
public class Solution {

    private static final int INITAIL_COUNT=1;
    private static final int MAX_COUNT=8;
    private static final int INITAIL_ANSWER=-1;
    private static final int NEXT_MULTIPLE_NUMBER=10;
    private static int answer = INITAIL_ANSWER;
	public int solution(int N, int number) {
        dfs(N,number,0,0);
        return answer;
    }

    private static void dfs(final int N, final int number, final int count, final int sum) {
        if (count>MAX_COUNT){
            return;
        }        
        if (number==sum){
            answer=createAnswer(count);
        }
        int nextN=N;
        for(int i=INITAIL_COUNT;i<=MAX_COUNT-count;i++){
            dfs(N, number, count+i, sum+nextN);
            dfs(N, number, count+i, sum-nextN);
            dfs(N, number, count+i, sum*nextN);
            dfs(N, number, count+i, sum/nextN);
            nextN=nextN*NEXT_MULTIPLE_NUMBER+N;
        }
    }

    private static int createAnswer(final int count) {
        if(answer==INITAIL_ANSWER){
            return count;
        }
        return Math.min(answer, count);
    }

	
}