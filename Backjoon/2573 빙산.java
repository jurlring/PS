import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {

    //1. 이차원 배열을 돌면서 0인 경우 상하좌우의 수를 깎는다.
    //2. 한 번 돌 때마다 이차원 배열 또 돌면서 BFS로 연결된 섬의 개수를 구한다.
    static int[][] xy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = 0;
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int mountain = checkMountain();
            if (mountain > 1) {
                break;
            } else if (mountain == 0) {
                count = 0;
                break;
            }
            melt();
            count++;
        }

        System.out.println(count);
    }

    private static int checkMountain() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && arr[i][j] > 0) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        visit = new boolean[n][m];
        return count;
    }

    private static void bfs(int i, int j) {
        queue.add(i);
        queue.add(j);
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            for (int p = 0; p < 4; p++) { // 상하좌우
                int c = a + xy[p][0];
                int d = b + xy[p][1];
                if (c >= 0 && c < n && d >= 0 && d < m) { // 존재하는 타일인지 확인
                    if (arr[c][d] > 0 && !visit[c][d]) {
                        queue.add(c);
                        queue.add(d);
                        visit[c][d] = true;
                    }
                }
            }
        }
    }

    private static void melt() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] <= 0) {
                    for (int p = 0; p < 4; p++) {
                        int a = i + xy[p][0];
                        int b = j + xy[p][1];
                        if (a >= 0 && a < n && b >= 0 && b < m) { // 상하좌우가 존재하는 타일인지 확인
                            queue.add(a);
                            queue.add(b);
                        }
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            arr[a][b] -= 1;
        }
    }
}
