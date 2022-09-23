package PS;

public class 비밀지도 {

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 12};
        boolean[] arr2 = {true, false, true};

    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
