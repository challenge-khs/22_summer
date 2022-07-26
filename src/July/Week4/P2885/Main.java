/*
    문제 제목: 초콜릿 식사
    주소: https://www.acmicpc.net/problem/2885
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-07-25
*/

package July.Week4.P2885;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int size, cnt, temp;
        size = 0;
        temp = 1;
        cnt = 0;

        while (temp < k) {
            temp *= 2;
            size = temp;
        }

        while (k > 0) {
            if (k >= temp) {
                k -= temp;
            } else {
                temp /= 2;
                cnt++;
            }
        }

        System.out.println(size + " " + cnt);
    }
}
