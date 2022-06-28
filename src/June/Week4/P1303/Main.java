/*
    문제 제목: 전쟁 - 전투
    주소: https://www.acmicpc.net/problem/1303
    알고리즘 분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
    풀이 날짜: 2022-06-27
*/

package June.Week4.P1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;

    static void dfs(int row, int col, char c) {
        visited[row][col] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (!visited[nx][ny]) {
                if (map[nx][ny] == c) {
                    dfs(nx, ny, c);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //System.out.println(n + " " + m);

        map = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            //System.out.println(input);
            for (int j = 0; j < n; j++) {
                char ch = input.charAt(j);
                map[i][j] = ch;
            }
        }

        int b = 0, w = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt = 0;
                    dfs(i, j, map[i][j]);

                    if(map[i][j] == 'W') {
                        w += cnt * cnt;
                    }
                    else
                        b += cnt * cnt;
                }
            }
        }

        System.out.println(w + " " + b);
    }
}
