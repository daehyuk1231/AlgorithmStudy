// 문제: 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
//
//항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

import java.util.*;

public class 방대혁_Programmers_43164 {
    public String[] solution(String[][] tickets) {
        // 1) 그래프 구성: 출발 -> (도착 리스트)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }

        // 2) Hierholzer (스택)
        Deque<String> stack = new ArrayDeque<>();
        List<String> route = new ArrayList<>();

        stack.push("ICN");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            PriorityQueue<String> pq = graph.get(cur);

            // 더 갈 곳이 있으면(사용할 티켓이 남았으면) 가장 사전순 도착지로 이동
            if (pq != null && !pq.isEmpty()) {
                stack.push(pq.poll()); // 티켓 1장 사용
            } else {
                // 갈 곳이 없으면 경로에 확정(백트래킹)
                route.add(stack.pop());
            }
        }

        // route는 역순으로 쌓이므로 뒤집기
        Collections.reverse(route);

        return route.toArray(new String[0]);
    }
}
