import java.util.LinkedList;
import java.util.Queue;
class Solution {
    int min = Integer.MAX_VALUE;
    int n;
    boolean[][] visited;
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n];
        bfs(board);
        return min;
    }
    
    public void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, -1));
        visited[0][0] = true;
        int [][]d={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.x == n - 1 && node.y == n - 1) {
                min = Math.min(min, node.cost);
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + d[i][0];
                int ny = node.y + d[i][1];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] != 1) {
                    int next;
                    if(node.dir == -1 || node.dir == i) { //직진
                        next = node.cost + 100;
                    } else { //코너
                        next = node.cost + 600;
                    }
                   
                    if(visited[nx][ny] == false || board[nx][ny] >= next) {
                        visited[nx][ny] = true;
                        board[nx][ny] = next; 
                        q.add(new Node(nx, ny, next, i));
                    }
                } 
            }
        }
    }
    
    class Node{
        int x;
        int y;
        int cost;
        int dir;
        
        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
//왠지 기억 안나는데 보자마자 dfs로 풀어야겠다고 생각했는데 안되서 생각해보니 bfs로 하면 되는거였음..
//board값을 next로 바꾸는 부분 