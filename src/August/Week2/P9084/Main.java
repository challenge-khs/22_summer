/*
    문제 제목: 동전
    주소: https://www.acmicpc.net/problem/9084
    알고리즘 분류: 다이나믹 프로그래밍, 배낭 문제
    풀이 날짜: 2022-08-11
*/


package August.Week2.P9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];

            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = coin[i]; j <= m; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }

            System.out.println(dp[m]);
        }
    }
}
