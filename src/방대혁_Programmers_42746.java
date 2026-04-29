// 문제: 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
import java.util.Arrays;

public class 방대혁_Programmers_42746 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        // 1) int -> String
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2) (b+a) vs (a+b) 비교로 내림차순 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 3) 가장 큰 값이 "0"이면 전부 0인 케이스
        if (arr[0].equals("0")) return "0";

        // 4) 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);

        return sb.toString();
    }
}