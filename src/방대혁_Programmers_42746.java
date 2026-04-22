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