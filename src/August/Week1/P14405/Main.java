/*
    문제 제목: 피카츄
    주소: https://www.acmicpc.net/problem/14405
    알고리즘 분류: 문자열
    풀이 날짜: 2022-08-06
*/

package August.Week1.P14405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replaceAll("pi|ka|chu", "");

        if (str.equals("")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
