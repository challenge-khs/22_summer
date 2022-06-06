/*
    문제 제목: 음식 평론가
    주소: https://www.acmicpc.net/problem/1188
    알고리즘 분류: 수학, 정수론
    풀이 날짜: 2022-06-06
*/

package June.Week1.P1188;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int gcd = 1; // 최대공약수

        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }

        System.out.println(m - gcd);
    }
}

