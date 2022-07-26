/*
    문제 제목: 동물원
    주소: https://www.acmicpc.net/problem/1309
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-07-26
*/

package July.Week4.P1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[n][i];
            sum %= 9901;
        }

        System.out.println(sum);
    }
}
