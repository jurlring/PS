import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 체스판다시칠하기 {

    static int editNum = Integer.MAX_VALUE;
    static int[][] arr;
    static String[] blackFirst = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
            "WBWBWBWB"};
    static String[] whithFirst = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
            "BWBWBWBW"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                calculateEditNumInBlack(i, j);
            }
        }

        System.out.println(editNum);
    }

    private static void calculateEditNumInBlack(int n, int m) {
        int numInBlack = 0;
        int numInWhite = 0;
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (arr[i][j] != blackFirst[i - n].charAt(j - m)) {
                    numInBlack++;
                } else {
                    numInWhite++;
                }
            }
        }
        editNum = Math.min(Math.min(numInBlack, numInWhite), editNum);
    }
}
