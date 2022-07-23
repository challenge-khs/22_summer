/*
    문제 제목: 삼각형만들기
    주소: https://www.acmicpc.net/problem/2622
    알고리즘 분류: 수학, 조합론
    풀이 날짜: 2022-07-23
*/

package July.Week3.P2622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; i + j + j <= n; j++) {
                int temp = n - i - j;
                if (i + j > temp)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
