/*
    문제 제목: 손익분기점
    주소: https://www.acmicpc.net/problem/1712
    알고리즘 분류: 수학, 사칙연산
    풀이 날짜: 2022-06-26
*/

package June.Week4.P1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (c <= b) {
            System.out.println("-1");
        } else {
            System.out.println((a / (c - b)) + 1);
        }
    }
}
