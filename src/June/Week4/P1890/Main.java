/*
    문제 제목: 점프
    주소: https://www.acmicpc.net/problem/1890
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-06-28
*/

package June.Week4.P1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int next = arr[i][j];
                if (next == 0) {
                    break;
                }
                if (j + next <= N) {
                    dp[i][j + next] += dp[i][j];
                }
                if (i + next <= N) {
                    dp[i + next][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}
