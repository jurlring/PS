class Solution {
    public static int solution(int[][] sizes) {
        int a = sizes[0][0];
        int b = sizes[0][1];

        for (int i = 1; i < sizes.length; i++) {
            int forward = Math.max(sizes[i][0] - a, 0) + Math.max(sizes[i][1] - b, 0);
            int reverse = Math.max(sizes[i][1] - a, 0) + Math.max(sizes[i][0] - b, 0);
            if (reverse < forward) {
                a = Math.max(a, sizes[i][1]);
                b = Math.max(b, sizes[i][0]);
                continue;
            }
            a = Math.max(a, sizes[i][0]);
            b = Math.max(b, sizes[i][1]);
        }
        return a * b;
    }
}