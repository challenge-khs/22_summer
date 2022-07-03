/*
    문제 제목: 결혼식
    주소: https://www.acmicpc.net/problem/5567
    알고리즘 분류: 그래프 이론, 그래프 탐색
    풀이 날짜: 2022-07-03
*/

package July.Week1.P5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static boolean visited[];
    static int cnt;

    static void dfs(int start, int depth) {
        if (depth == 2) {
            return;
        }

        for (int value : adj[start]) {
            visited[value] = true;
            dfs(value, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cnt = 0;

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }

        visited[1] = true;
        dfs(1, 0);

        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
