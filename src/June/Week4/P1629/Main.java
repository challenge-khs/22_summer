/*
    문제 제목: 곱셈
    주소: https://www.acmicpc.net/problem/1629
    알고리즘 분류: 수학, 분할 정복을 이용한 거듭제곱
    풀이 날짜: 2022-06-24
*/

package June.Week4.P1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long mul(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long temp = mul(a, b / 2, c);
        if (b % 2 == 1) {
            return temp * temp % c * a % c;
        } else {
            return temp * temp % c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(mul(a, b, c));
    }
}
