import java.util.HashSet;
import java.util.Set;

public class 방대혁_Programmers_1845 {
    public int solution(int[] nums) {
        Set<Integer> kinds = new HashSet<>();

        for (int n : nums) {
            kinds.add(n); // 중복이면 무시, 처음이면 추가
        }

        int pick = nums.length / 2;          // 내가 가져갈 수 있는 마리 수
        int unique = kinds.size();           // 서로 다른 종류 수

        return Math.min(unique, pick);
    }
}
