// 문제: 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
//
//1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
//2. words에 있는 단어로만 변환할 수 있습니다.
//예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
//
//두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

import java.util.LinkedList;
import java.util.Queue;

public class 방대혁_Programmers_43163 {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        Queue<Integer> distQ = new LinkedList<>();

        q.offer(begin);
        distQ.offer(0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int dist = distQ.poll();

            if (cur.equals(target)) return dist;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                if (diffOne(cur, words[i])) {
                    visited[i] = true;
                    q.offer(words[i]);
                    distQ.offer(dist + 1);
                }
            }
        }

        return 0;
    }

    // 두 단어가 정확히 한 글자만 다른지
    private boolean diffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
