// 문제: H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
//
//어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
//
//어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
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