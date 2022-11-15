import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS {

    static boolean [] isVisit;
    static boolean[][] link;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int 시작노드 = Integer.parseInt(split[2]);

        link = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            split = reader.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            link[a][b] = true;
            link[b][a] = true;
        }
        isVisit = new boolean[n+1];
        getDfs(시작노드, n);
        System.out.println();

        isVisit = new boolean[n+1];
        getBfs(시작노드, n);
    }

    private static void getDfs(int 시작노드, int 전체노드) {
        System.out.print(시작노드 + " ");
        isVisit[시작노드] = true;
        for (int i = 1; i <= 전체노드; i++) {
            if (link[시작노드][i] && !isVisit[i]) {
                getDfs(i, 전체노드);
            }
        }
    }

    private static void getBfs(int 시작노드, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(시작노드);
        while (q.size() > 0) {
            Integer num = q.poll();
            System.out.print(num + " ");
            isVisit[num] = true;
            for (int i = 1; i <= n; i++) {
                if (link[num][i] && !isVisit[i]) {
                    q.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}
