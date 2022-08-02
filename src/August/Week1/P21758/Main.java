/*
    문제 제목: 꿀 따기
    주소: https://www.acmicpc.net/problem/21758
    알고리즘 분류: 그리디 알고리즘, 누적 합, 많은 조건 분기
    풀이 날짜: 2022-08-02
*/

package August.Week1.P21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        long ans = 0;

        for (int i = 2; i < n; i++) { // 벌 벌 꿀통
            ans = Math.max(ans, sum[n] - arr[1] - arr[i] + sum[n] - sum[i]);
        }
        for (int i = 2; i < n; i++) { // 꿀통 벌 벌
            ans = Math.max(ans, sum[n] - arr[n] - arr[i] + sum[i - 1]);
        }
        for (int i = 2; i < n; i++) { // 벌 꿀통 벌
            ans = Math.max(ans, sum[i] - arr[1] + sum[n] - sum[i - 1] - arr[n]);
        }

        System.out.println(ans);
    }
}
