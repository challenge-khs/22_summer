/*
    문제 제목: 맥주 마시면서 걸어가기
    주소: https://www.acmicpc.net/problem/9205
    알고리즘 분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색
    풀이 날짜: 2022-06-09
*/


package June.Week2.P9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Pos[] path;
    static int n;
    static ArrayList<ArrayList<Integer>> map;

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if(temp == n + 1)
                return true;

            for (int i = 0; i < map.get(temp).size(); i++) {
                int next = map.get(temp).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            path = new Pos[n + 2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                path[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            map = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Math.abs(path[i].x - path[j].x) + Math.abs(path[i].y - path[j].y) <= 1000) {
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }

            if(bfs())
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
}
