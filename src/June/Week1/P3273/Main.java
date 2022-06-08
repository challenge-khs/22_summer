/*
    문제 제목: 두 수의 합
    주소: https://www.acmicpc.net/problem/3273
    알고리즘 분류: 정렬, 투 포인터
    풀이 날짜: 2022-06-07
*/

package June.Week1.P3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int x = Integer.parseInt(br.readLine());

        int cnt = 0;
        int start = 1;
        int end = n;
        int sum = 0;

        while (start < end) {
            sum = a[start] + a[end];
            if(sum == x) {
                cnt++;
            }

            if (sum <= x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(cnt);
    }
}
