/*
    문제 제목: 다이얼
    주소: https://www.acmicpc.net/problem/5622
    알고리즘 분류: 구현
    풀이 날짜: 2022-08-16
*/

package August.Week3.P5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp < 68) cnt += 3;
            else if (temp < 71) cnt += 4;
            else if (temp < 74) cnt += 5;
            else if (temp < 77) cnt += 6;
            else if (temp < 80) cnt += 7;
            else if (temp < 84) cnt += 8;
            else if (temp < 87) cnt += 9;
            else cnt += 10;
        }

        System.out.println(cnt);
    }
}
