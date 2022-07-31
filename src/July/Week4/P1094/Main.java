/*
    문제 제목: 막대기
    주소: https://www.acmicpc.net/problem/1094
    알고리즘 분류: 수학, 비트마스킹
    풀이 날짜: 2022-07-31
*/

package July.Week4.P1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (x > 0) {
            if (x % 2 == 1) {
                cnt++;
            }
            x /= 2;
        }

        System.out.println(cnt);
    }
}
