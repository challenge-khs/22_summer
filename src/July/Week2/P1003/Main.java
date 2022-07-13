/*
    문제 제목: 피보나치 함수
    주소: https://www.acmicpc.net/problem/1003
    알고리즘 분류: 다이나믹 프로그래밍
    풀이 날짜: 2022-07-13
*/

package July.Week2.P1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] fib0 = new int[41];
            int[] fib1 = new int[41];
            fib0[0] = 1;
            fib0[1] = 0;
            fib1[0] = 0;
            fib1[1] = 1;

            for (int i = 2; i <= n; i++) {
                fib0[i] = fib0[i - 1] + fib0[i - 2];
                fib1[i] = fib1[i - 1] + fib1[i - 2];
            }

            System.out.println(fib0[n] + " " + fib1[n]);
        }
    }
}
