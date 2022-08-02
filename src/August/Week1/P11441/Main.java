/*
    문제 제목: 합 구하기
    주소: https://www.acmicpc.net/problem/11441
    알고리즘 분류: 누적 합
    풀이 날짜: 2022-08-02
*/

package August.Week1.P11441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] asum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum += Integer.parseInt(st.nextToken());
            asum[i] = sum;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(asum[b] - asum[a - 1]);
        }
    }
}
