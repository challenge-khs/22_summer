/*
    문제 제목: A와 B
    주소: https://www.acmicpc.net/problem/12904
    알고리즘 분류: 구현, 문자열, 그리디 알고리즘
    풀이 날짜: 2022-07-07
*/

package July.Week1.P12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// T에서 S로 만들 수 있는 지를 판별
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() < t.length()) {
            if (t.endsWith("A")) {
                t = t.substring(0, t.length() - 1);
            } else if (t.endsWith("B")) {
                t = t.substring(0, t.length() - 1);
                sb = new StringBuilder(t);
                t = sb.reverse().toString();
            }
        }

        String result = s.equals(t) ? "1" : "0";

        System.out.println(result);
    }
}

