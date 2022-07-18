/*
    문제 제목: RGB 거리
    주소: https://www.acmicpc.net/problem/1149
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-07-18
*/

package July.Week3.P1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][j];
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}
