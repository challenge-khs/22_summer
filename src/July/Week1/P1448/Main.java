/*
    문제 제목: 삼각형 만들기
    주소: https://www.acmicpc.net/problem/1448
    알고리즘 분류: 수학, 그리디 알고리즘, 정렬
    풀이 날짜: 2022-06-30
*/

package July.Week1.P1448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // a + b > c

        Arrays.sort(arr, Collections.reverseOrder());

        int a, b, c, sum = 0;
        boolean flag = false;
        for (int i = 0; i < n - 2; i++) {
            c = arr[i];
            b = arr[i + 1];
            a = arr[i + 2];
            //System.out.println(a + " " + b + " " + c);
            if (a + b > c) {
                sum = a + b + c;
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(sum);
        } else {
            System.out.println("-1");
        }
    }
}
