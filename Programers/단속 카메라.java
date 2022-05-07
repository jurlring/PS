package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ControlCamera {
    //List를 돌면서 가장 빠른 end 값으로 count
    //end값이 포함되는 route 제거
    //end값을 지나면 다시 새로운 end로 고정

    class Route implements Comparable<Route> {
        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o1) {
            if (o1.end < this.end) {
                return 1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int end = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > end) {
                end = route[1];
                answer++;
            }
        }
        return answer;
    }
}
