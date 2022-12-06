import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    //보관 후 하루가 지나면 익은 토마토 사방의 익지 않은 토마토가 익는다.
    //철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 최소 일 수를 알고 싶음

    //전체를 순회하면서, 익은 토마토로 바꾸는 과정
    //익은 토마토를 보고 dfs or bfs, 익지 않은 토마토라면 익은 토마토로 만들고 큐에 넣는다.

    static int[][] tomatoes;
    static int[][] arr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        int days = 0;
        Queue<Integer> queue = new LinkedList<>();

        int unripeTomatoes = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                } else if (tomatoes[i][j] == 0) {
                    unripeTomatoes++;
                }
            }
        }

        days = bfs(days, queue, unripeTomatoes);

        System.out.println(days);
    }

    private static int bfs(int days, Queue<Integer> queue, int unripeTomatoes) {
        if (queue.size() == 0) {
            days = -1;
        }
        while (unripeTomatoes > 0 && !queue.isEmpty()) {
            int size = queue.size() / 2;
            int ripe = 0;
            for (int i = 0; i < size; i++) {
                Integer a = queue.poll();
                Integer b = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = a + arr[k][0];
                    int y = b + arr[k][1];
                    if (x < N && x >= 0 && y < M && y >= 0) {
                        if (tomatoes[x][y] == 0) {
                            ripe++;
                            tomatoes[x][y] = 1;
                            queue.add(x);
                            queue.add(y);
                        }
                    }
                }
            }
            if (ripe == 0) {
                days = -1;
                break;
            }
            unripeTomatoes -= ripe;
            days++;
        }
        return days;
    }
}
