/*
    문제 제목: 더하기 사이클
    주소: https://www.acmicpc.net/problem/1110
    알고리즘 분류: 수학, 구현
    풀이 날짜: 2022-07-30
*/

package July.Week4.P1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int copy = n;

        while (true) {
            n = ((n % 10) * 10 + ((n / 10) + (n % 10)) % 10);
            cnt++;

            if (copy == n) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
