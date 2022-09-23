package PS.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 신고_결과_받기 {
    //이용자의 ID가 담긴 문자열 배열 id_list,
    //각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report,
    //정지 기준이 되는 신고 횟수 k
    //한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
    //각 유저별로 신고한 유저가 신고 횟수를 넘어서 정말 신고됐다는 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수

    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> reportList = Arrays.stream(report)
                .distinct()
                .collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        for (String s : reportList) {
            String[] split = s.split(" ");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        return Arrays.stream(id_list)
                .map(user -> {
                    List<String> list = reportList.stream().filter(re -> re.startsWith(user + " "))
                            .map(re -> re.split(" ")[0]).collect(
                                    Collectors.toList());
                    return list.stream().filter(singo -> map.getOrDefault(singo, 0) > k).count();
                }).mapToInt(Long::intValue).toArray();
    }
}
