import java.util.Arrays;

public class 방대혁_Programmers_42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순

        int n = citations.length;
        int h = 0;

        // 뒤에서부터 보며 (내림차순 효과)
        for (int i = 0; i < n; i++) {
            int cited = citations[n - 1 - i]; // i번째로 큰 값
            int papers = i + 1;               // 상위 papers편

            if (cited >= papers) {
                h = papers;                   // 조건 만족하면 h 갱신
            } else {
                break;                        // 내림차순이라 이후는 더 작아져서 불가능
            }
        }

        return h;
    }
}