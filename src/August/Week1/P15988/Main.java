/*
    문제 제목: 1, 2, 3 더하기 3
    주소: https://www.acmicpc.net/problem/15988
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-08-03
*/

package August.Week1.P15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
        }

        while (T-- > 0) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
