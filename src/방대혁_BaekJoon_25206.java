//문제: 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
//
//치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
//
//전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
//
//인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
//
//P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
//
//과연 치훈이는 무사히 졸업할 수 있을까?
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방대혁_BaekJoon_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total_score = 0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (!grade.equals("P")) {
                total_score += score;
                double m = switch (grade) {
                    case "A+" -> 4.5;
                    case "A0" -> 4.0;
                    case "B+" -> 3.5;
                    case "B0" -> 3.0;
                    case "C+" -> 2.5;
                    case "C0" -> 2.0;
                    case "D+" -> 1.5;
                    case "D0" -> 1.0;
                    case "F" -> 0.0;
                    default -> 0;
                };
                sum += score * m;
            }
        }
        System.out.println(sum / total_score);
    }
}
