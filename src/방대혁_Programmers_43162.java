//문제: 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
//
//컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
public class 방대혁_Programmers_43162 {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int network = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                network++; // DFS 한 번 = 네트워크 하나
            }
        }

        return network;
    }

    private void dfs(int cur, int[][] computers, int n) {
        visited[cur] = true;

        for (int next = 0; next < n; next++) {
            if (!visited[next] && computers[cur][next] == 1) {
                dfs(next, computers, n);
            }
        }
    }
}