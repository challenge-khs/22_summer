/*
    문제 제목: 극장 좌석
    주소: https://www.acmicpc.net/problem/2302
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-08-03
*/

package August.Week1.P2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long ans = 1;
        int before = 0;
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= dp[temp - before - 1];
            before = temp;
        }
        ans *= dp[n - before];

        System.out.println(ans);
    }
}
