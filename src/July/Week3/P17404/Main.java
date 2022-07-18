/*
    문제 제목: RGB 거리 2
    주소: https://www.acmicpc.net/problem/17404
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-07-18
*/

package July.Week3.P17404;

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
        int[] cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = arr[1][j];
                } else {
                    dp[1][j] = 1001;
                }
            }
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];

                if (j == n) {
                    if (i == 0) {
                        cost[i] = Math.min(dp[n][1], dp[n][2]);
                    }
                    if (i == 1) {
                        cost[i] = Math.min(dp[n][0], dp[n][2]);
                    }
                    if (i == 2) {
                        cost[i] = Math.min(dp[n][0], dp[n][1]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, cost[i]);
        }

        System.out.println(answer);
    }
}
