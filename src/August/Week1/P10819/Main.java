/*
    문제 제목: 차이를 최대로
    주소: https://www.acmicpc.net/problem/10819
    알고리즘 분류: 브루트포스 알고리즘, 백트래킹
    풀이 날짜: 2022-08-07
*/

package August.Week1.P10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[] a, temp;
    static boolean[] visited;

    static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += Math.abs(temp[i - 1] - temp[i]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = a[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        temp = new int[n];
        visited = new boolean[n];
        answer = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }
}
