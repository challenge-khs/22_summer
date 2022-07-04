/*
    문제 제목: 가장 큰 증가 부분 수열
    주소: https://www.acmicpc.net/problem/11055
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-07-04
*/

package July.Week1.P11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i];
            for (int j = 1; j <= n; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
