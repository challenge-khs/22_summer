/*
    문제 제목: 게임을 만든 동준이
    주소: https://www.acmicpc.net/problem/2847
    알고리즘 분류: 그리디 알고리즘
    풀이 날짜: 2022-06-28
*/

package June.Week4.P2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //System.out.println(n);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            //System.out.println(arr[i]);
        }

        int sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] <= arr[i]) {
                int temp = arr[i] - arr[i + 1]  + 1;
                sum += temp;
                arr[i] -= temp;
            }
        }

        System.out.println(sum);
    }
}
