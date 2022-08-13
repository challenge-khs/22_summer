/*
    문제 제목: 사과 담기 게임
    주소: https://www.acmicpc.net/problem/2828
    알고리즘 분류: 그리디 알고리즘
    풀이 날짜: 2022-08-13
*/

package August.Week2.P2828;

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
        int j = Integer.parseInt(br.readLine());

        int cnt = 0;
        int left = 0;
        int right = m - 1;

        for (int i = 0; i < j; i++) {
            int temp = Integer.parseInt(br.readLine());
            temp--;
            if (temp > right) {
                cnt += temp - right;
                right = temp;
                left = temp - (m - 1);
            } else if (temp < left) {
                cnt += left - temp;
                left = temp;
                right = temp + m - 1;
            }
        }

        System.out.println(cnt);
    }
}
