package PS;

import java.util.Arrays;
import java.util.Optional;

public class WordConvert {

    private int answer = 0;
    private boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        Optional<String> finding = Arrays.stream(words).findFirst();
        if (finding.isEmpty()) {
            return answer;
        }
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visit[i]) {
                continue;
            }
            int matched = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == begin.charAt(j)) {
                    matched++;
                }
            }
            if (matched == begin.length() - 1) {
                visit[i] = true;
                dfs(words[i], target, words, count + 1);
                visit[i] = false;
            }
        }
    }

}
