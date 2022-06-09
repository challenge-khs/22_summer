/*
    문제 제목: 제곱수의 합
    주소: https://www.acmicpc.net/problem/1699
    알고리즘 분류: 수학, 다이나믹 프로그래밍
    풀이 날짜: 2022-06-09
*/

package June.Week2.P1699;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[100001];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
