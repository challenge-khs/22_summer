/*
    문제 제목: Project Teams
    주소: https://www.acmicpc.net/problem/20044
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-07-23
*/

package July.Week3.P20044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //System.out.println(i + " " + arr[i] + arr[2 * n - 1 - i]);
            min = Math.min(min, arr[i] + arr[2 * n - 1 - i]);
        }

        System.out.println(min);
    }
}
