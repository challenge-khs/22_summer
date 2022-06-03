/*
    문제 제목: 숫자의 개수
    주소: https://www.acmicpc.net/problem/2577
    알고리즘 분류: 수학, 구현, 사칙연산
    풀이 날짜: 2022-06-03
*/

package June.Week1.P2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        int[] arr = new int[10];

        String str = Long.toString(a * b * c);

        for (int i = 0; i < str.length(); i++) {
            arr[(int) (str.charAt(i) - '0')]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
