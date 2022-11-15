import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    static int[][] arr;
    static int minStep = Integer.MAX_VALUE;
    static int n;
    static int m;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n][m];
        isVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        isVisit[0][0] = true;

        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            if (i != n - 1 && !isVisit[i + 1][j] && arr[i + 1][j] == 1) {
                q.add(i + 1);
                q.add(j);
                arr[i + 1][j] = arr[i][j] + 1;
            }
            if (j != m - 1 && !isVisit[i][j + 1] && arr[i][j + 1] == 1) {
                q.add(i);
                q.add(j + 1);
                arr[i][j + 1] = arr[i][j] + 1;
            }
            if (i != 0 && !isVisit[i - 1][j] && arr[i - 1][j] == 1) {
                q.add(i - 1);
                q.add(j);
                arr[i - 1][j] = arr[i][j] + 1;
            }
            if (j != 0 && !isVisit[i][j - 1] && arr[i][j - 1] == 1) {
                q.add(i);
                q.add(j - 1);
                arr[i][j - 1] = arr[i][j] + 1;
            }
        }
    }
}
