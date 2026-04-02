// 문제: 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class 방대혁_BaekJoon_9498 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (100 >= num && num >= 90) System.out.println("A");
        else if (89 >= num && num >= 80) System.out.println("B");
        else if (79 >= num && num >= 70) System.out.println("C");
        else if (69 >= num && num >= 60) System.out.println("D");
        else System.out.println("F");
    }
}
