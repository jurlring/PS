package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {

    //노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래를 장르별로 2개씩 고유 번호를 순서대로 return
//    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    //1. 장르 별 재생 횟수 구하기 => Map or priority queue 장르이름 + 재생횟수 저장해서 많은 것 부터 꺼내기
    //2. 장르 별로 (고유 번호,재생 횟수) 저장

    class Song implements Comparable<Song> {
        int number;
        long plays;

        public Song(int number, long plays) {
            this.number = number;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song o1) {
            if (o1.plays > this.plays) {
                return 1;
            } else if (o1.plays == this.plays) {
                if (o1.number < this.number) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "number=" + number +
                    ", plays=" + plays +
                    '}';
        }
    }

    List<Integer> bestAlbum = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Long> genreWithPlaySize = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new LinkedHashMap<>();
        // 장르별 재생횟수 + 장르별 고유번호+재생횟수
        for (int i = 0; i < plays.length; i++) {
            genreWithPlaySize.put(genres[i], genreWithPlaySize.getOrDefault(genres[i], 0L) + plays[i]);
            List<Song> songList = songsByGenre.getOrDefault(genres[i], new ArrayList<>());
            songList.add(new Song(i, plays[i]));
            songsByGenre.put(genres[i], songList);
        }
        //장르 별 재생 횟수로 정렬
        List<String> genreList = new ArrayList<>(genreWithPlaySize.keySet());
        Collections.sort(genreList, (v1, v2) -> genreWithPlaySize.get(v2).compareTo(genreWithPlaySize.get(v1)));


        for (String g : genreList) {
            findBestAlbum(songsByGenre.get(g));
        }
        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findBestAlbum(List<Song> songs) {
        if (songs.size() == 1) {
            bestAlbum.add(songs.get(0).number);
            return;
        }
        Collections.sort(songs);
        for (int i = 0; i < 2; i++) {
            bestAlbum.add(songs.get(i).number);
        }
    }
}
