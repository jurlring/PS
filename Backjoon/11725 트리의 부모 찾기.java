import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의_부모_찾기 {

    // 트리의 루트가 1
    // 2번 노드부터 순서대로 부모 노드를 구하는 프로그램

    // 연결된 노드 표현
    // 1번 노드부터 BFS로 돌면서 부모 노드 구하기
    static boolean[] visit;
    static int[] rootNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        rootNodes = new int[n + 1];

        Map<Integer, List<Integer>> linkedNodes = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            linkedNodes.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            List<Integer> leftList = linkedNodes.get(left);
            leftList.add(right);
            linkedNodes.put(left, leftList);
            List<Integer> rightList = linkedNodes.get(right);
            rightList.add(left);
            linkedNodes.put(right, rightList);
        }
        bfs(n, linkedNodes);
        for (int i = 2; i <= n; i++) {
            System.out.println(rootNodes[i]);
        }
    }

    private static void bfs(int n, Map<Integer, List<Integer>> linkedNodes) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            Integer root = q.poll();
            List<Integer> childs = linkedNodes.get(root);
            for (Integer child : childs) {
                if (!visit[child]) {// 방문하지 않았다면
                    rootNodes[child] = root;
                    q.add(child);
                    visit[child] = true;
                }
            }
        }
    }
}
