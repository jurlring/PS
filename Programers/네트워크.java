
public class Solution {

    static boolean[] visit;
    static int answer = 0;
    static int solution(int n, int[][] computers) {
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            checkVisit(n, computers, i);
        }
        return answer;
    }

    private static void checkVisit(int n, int[][] computers, int i) {
        if (!visit[i]){
            answer++;
            dfs(computers,i,n);
        }
    }
    
    private static void dfs(int[][] computers, int index, int n) {
        visit[index]=true;
        for(int i=0;i<n;i++){
            checkDfs(computers, index, n, i);
        }
    }

    private static void checkDfs(int[][] computers, int index, int n, int i) {
        if (i!=index&&computers[index][i]==1&&!visit[i]){
            dfs(computers, i, n);
        }
    }

    public static void main(String[] args) {
        int[][] computers={{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, computers));

    }

}