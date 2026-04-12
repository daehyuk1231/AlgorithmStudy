// 문제: 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//명령은 총 여섯 가지이다.
//
//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 방대혁_BaekJoon_18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.substring(5));
                queue.offer(x);
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
            } else if (command.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
