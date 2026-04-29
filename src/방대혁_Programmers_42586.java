// 문제: 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//
//또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
import java.util.ArrayList;
import java.util.List;

public class 방대혁_Programmers_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        // 1) 각 기능의 완료까지 필요한 일수 계산
        int n = progresses.length;
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];                 // 남은 작업량
            days[i] = (remain + speeds[i] - 1) / speeds[i];   // 올림 나눗셈
        }

        // 2) 앞에서부터 배포 묶기
        int 기준일 = days[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (days[i] <= 기준일) {
                // 뒤 기능이 더 빨리(또는 같은 날) 끝나면 같이 배포
                count++;
            } else {
                // 새로운 배포 시작
                result.add(count);
                기준일 = days[i];
                count = 1;
            }
        }

        // 마지막 묶음 추가
        result.add(count);

        // List<Integer> -> int[]
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}