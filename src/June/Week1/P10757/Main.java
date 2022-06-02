/*
    문제 제목: 큰 수 A+B
    주소: https://www.acmicpc.net/problem/10757
    알고리즘 분류: 수학, 구현, 사칙연산, 임의 정밀도 / 큰 수 연산
    풀이 날짜: 2022-06-02
*/

package June.Week1.P10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.add(b));
    }
}
