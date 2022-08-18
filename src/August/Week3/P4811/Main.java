/*
    문제 제목: 알약
    주소: https://www.acmicpc.net/problem/4811
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-08-18
*/

package August.Week3.P4811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[31][31];
        for (int i = 1; i < 31; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < 31; i++) {
            for (int j = 0; j < 30; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            System.out.println(dp[n][0]);
        }
    }
}
