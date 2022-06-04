/*
    문제 제목: 나머지
    주소: https://www.acmicpc.net/problem/3052
    알고리즘 분류: 수학, 사칙연산
    풀이 날짜: 2022-06-04
*/

package June.Week1.P3052;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[43];
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            check[(a % 42)] = true;
        }

        for (int i = 0; i < 43; i++) {
            if (check[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
