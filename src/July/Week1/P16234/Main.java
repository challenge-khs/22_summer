/*
    문제 제목: 인구 이동
    주소: https://www.acmicpc.net/problem/16234
    알고리즘 분류: 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 시뮬레이션
    풀이 날짜: 2022-07-06
*/

package July.Week1.P16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] a;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        a = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        boolean flag = false;

        while (true) {
            visited = new boolean[N][N];
            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j])
                        continue;
                    if(bfs(i, j))
                        flag = true;
                }
            }

            if (flag) cnt++;
            else break;
        }

        System.out.println(cnt);
    }

    static boolean bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> arr = new ArrayList<>();

        q.add(new Node(x, y));
        arr.add(new Node(x, y));
        visited[x][y] = true;
        int sum = a[x][y];

        while (!q.isEmpty()) {
            Node temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.r + dx[i];
                int ny = temp.c + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }
                int diff = Math.abs(a[temp.r][temp.c] - a[nx][ny]);
                if (diff < L || diff > R) {
                    continue;
                }

                sum += a[nx][ny];
                q.add(new Node(nx, ny));
                arr.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if(arr.size() < 2)
            return false;
        int div = sum / arr.size();
        for (Node node : arr) {
            a[node.r][node.c] = div;
        }
        return true;
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
