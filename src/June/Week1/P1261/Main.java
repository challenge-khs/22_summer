/*
    문제 제목: 알고스팟
    주소: https://www.acmicpc.net/problem/1261
    알고리즘 분류: 그래프 이론, 다익스트라, 0-1 너비 우선 탐색
    풀이 날짜: 2022-06-07
*/

package June.Week1.P1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dist;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static int dijkstra() {
        Queue<Node> q = new LinkedList<>();
        dist[1][1] = 0;
        q.add(new Node(1, 1, 0));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n) {
                    if (dist[nx][ny] > dist[temp.x][temp.y] + map[nx][ny]) {
                        dist[nx][ny] = dist[temp.x][temp.y] + map[nx][ny];
                        q.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        return dist[m][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m + 1][n + 1];
        dist = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            String input = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(dijkstra());
    }
}
