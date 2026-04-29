// 문제: 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//
//속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 방대혁_Programmers_42579 {
    static class Song {
        int id;
        int play;

        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalByGenre = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        // 1) 장르별 총합 + 장르별 노래 목록 만들기
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            totalByGenre.put(g, totalByGenre.getOrDefault(g, 0) + p);

            songsByGenre.putIfAbsent(g, new ArrayList<>());
            songsByGenre.get(g).add(new Song(i, p));
        }

        // 2) 장르를 "총 재생수" 기준으로 내림차순 정렬
        List<String> genreOrder = new ArrayList<>(totalByGenre.keySet());
        genreOrder.sort((a, b) -> totalByGenre.get(b) - totalByGenre.get(a));

        // 3) 각 장르에서 상위 2곡씩 뽑기
        List<Integer> answer = new ArrayList<>();

        for (String g : genreOrder) {
            List<Song> list = songsByGenre.get(g);

            // (재생수 desc, id asc)
            list.sort((s1, s2) -> {
                if (s1.play != s2.play) return s2.play - s1.play;
                return s1.id - s2.id;
            });

            answer.add(list.get(0).id);
            if (list.size() > 1) answer.add(list.get(1).id);
        }

        // List<Integer> -> int[]
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) result[i] = answer.get(i);
        return result;
    }
}
