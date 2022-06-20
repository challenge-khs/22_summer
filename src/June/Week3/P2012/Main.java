/*
    문제 제목: 등수 매기기
    주소: https://www.acmicpc.net/problem/2012
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-06-20
*/

package June.Week3.P2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(arr[i] - (i + 1));
        }

        System.out.println(sum);
    }
}
