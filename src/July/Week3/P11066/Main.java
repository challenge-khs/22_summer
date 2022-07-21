/*
    문제 제목: 파일 합치기
    주소: https://www.acmicpc.net/problem/11066
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-07-21
*/

package July.Week3.P11066;

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
            int[] arr = new int[n + 1];
            int[] sum = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; i + j <= n; j++) {
                    int k = i + j;
                    dp[j][k] = Integer.MAX_VALUE;
                    for (int l = j; l < k; l++) {
                        dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l + 1][k] + sum[k] - sum[j - 1]);
                    }
                }
            }

            System.out.println(dp[1][n]);
        }
    }
}
