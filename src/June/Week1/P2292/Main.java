/*
    문제 제목: 벌집
    주소: https://www.acmicpc.net/problem/2
    알고리즘 분류: 수학
    풀이 날짜: 2022-06-01
*/

package June.Week1.P2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int range = 2;

        if (n == 1) {
            System.out.println(1);
        } else {
            while (range <= n) {
                range = range + (6 * cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
