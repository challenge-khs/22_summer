/*
    문제 제목: 1로 만들기 2
    주소: https://www.acmicpc.net/problem/12852
    알고리즘 분류: 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색
    풀이 날짜: 2022-07-12
*/
package July.Week2.P12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] value = new int[n + 1];

        dp[1] = 0;
        value[1] = -1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            value[i] = i - 1;

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                value[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                value[i] = i / 2;
            }
        }

        int num = dp[n];
        System.out.println(num);

        int idx = n;
        for (int i = 0; i <= num; i++) {
            System.out.print(idx + " ");
            idx = value[idx];
        }

    }
}
