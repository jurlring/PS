import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 신입사원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Employee> e = new PriorityQueue<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                e.add(new Employee(a, b));
            }
            greedy(e);
        }
    }

    private static void greedy(PriorityQueue<Employee> e) {
        int size = e.size();
        Stack<Employee> q = new Stack<>();
        for (int j = 0; j < size; j++) {
            Employee poll = e.poll();
            int a = poll.a;
            int b = poll.b;
            while (!q.isEmpty()) {
                Employee employee = q.peek();
                if (a < employee.a && b < employee.b) { // 새로운 사원이 모두 등수가 높은 경우
                    q.pop();
                } else if (a < employee.a || b < employee.b) {
                    q.add(new Employee(a, b));
                    break;
                } else if (a > employee.a && b > employee.b) {
                    break;
                }
            }
            if (q.isEmpty()) {
                q.add(new Employee(a, b));
            }
        }
        System.out.println(q.size());
    }

    static class Employee implements Comparable<Employee> {
        int a;
        int b;

        public Employee(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Employee o) {
            if (o.a > this.a) {
                return -1;
            }
            return 1;
        }
    }
}
