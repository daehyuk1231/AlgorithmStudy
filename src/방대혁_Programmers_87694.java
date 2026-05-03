//문제: 다음과 같은 다각형 모양 지형에서 캐릭터가 아이템을 줍기 위해 이동하려 합니다.
//
//지형은 각 변이 x축, y축과 평행한 직사각형이 겹쳐진 형태로 표현하며, 캐릭터는 이 다각형의 둘레(굵은 선)를 따라서 이동합니다.
//
//만약 직사각형을 겹친 후 다음과 같이 중앙에 빈 공간이 생기는 경우, 다각형의 가장 바깥쪽 테두리가 캐릭터의 이동 경로가 됩니다.
//
//단, 서로 다른 두 직사각형의 x축 좌표 또는 y축 좌표가 같은 경우는 없습니다.
//
//즉, 위 그림처럼 서로 다른 두 직사각형이 꼭짓점에서 만나거나, 변이 겹치는 경우 등은 없습니다.
//
//다음 그림과 같이 지형이 2개 이상으로 분리된 경우도 없습니다.
//
//한 직사각형이 다른 직사각형 안에 완전히 포함되는 경우 또한 없습니다.
//
//지형을 나타내는 직사각형이 담긴 2차원 배열 rectangle, 초기 캐릭터의 위치 characterX, characterY, 아이템의 위치 itemX, itemY가 solution 함수의 매개변수로 주어질 때, 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 return 하도록 solution 함수를 완성해주세요.
import java.util.LinkedList;
import java.util.Queue;

public class 방대혁_Programmers_87694 {
    static final int MAX = 102; // 좌표 최대 50 -> 2배 100, 여유 포함
    int[][] board = new int[MAX + 1][MAX + 1]; // 0: 빈공간, 1: 테두리(이동가능), 2: 내부(이동불가)

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        // 1) 모든 직사각형을 2배 확장해서 채우기 (전체 영역을 2로 마킹)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 2; // 일단 전부 채움
                }
            }
        }

        // 2) 내부 제거: 직사각형 내부는 0으로 만들고(막기), 테두리만 1로 남기기
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;

            // 내부는 (x1+1 ~ x2-1, y1+1 ~ y2-1)
            for (int x = x1 + 1; x <= x2 - 1; x++) {
                for (int y = y1 + 1; y <= y2 - 1; y++) {
                    board[x][y] = 0;
                }
            }
        }

        // 3) 이제 board에서 값이 2인 곳은 테두리 후보인데,
        //    내부 제거 후 남은 2를 "이동 가능 테두리(1)"로 바꿔준다.
        for (int x = 0; x <= MAX; x++) {
            for (int y = 0; y <= MAX; y++) {
                if (board[x][y] == 2) board[x][y] = 1;
            }
        }

        // 4) BFS
        int sx = characterX * 2, sy = characterY * 2;
        int tx = itemX * 2, ty = itemY * 2;

        int[][] dist = new int[MAX + 1][MAX + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == tx && y == ty) {
                // dist는 1부터 시작했으니 -1 해주고, 2배 확장했으니 /2
                return (dist[x][y] - 1) / 2;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx > MAX || ny < 0 || ny > MAX) continue;
                if (board[nx][ny] != 1) continue;        // 테두리만 이동 가능
                if (dist[nx][ny] != 0) continue;         // 방문 체크

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return -1; // 문제 조건상 보통 도달 가능
    }
}