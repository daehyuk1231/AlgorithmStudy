import java.util.Arrays;

public class 방대혁_Programmers_42577 {
    public boolean solution(String[] phone_book) {

        // 1. 전화번호 정렬
        Arrays.sort(phone_book);

        // 2. 인접한 번호끼리만 접두어 검사
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
