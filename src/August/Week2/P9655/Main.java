/*
    문제 제목: 돌 게임
    주소: https://www.acmicpc.net/problem/9655
    알고리즘 분류: 수학, 다이나믹 프로그래밍, 게임 이론
    풀이 날짜: 2022-08-12
*/

package August.Week2.P9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
