/*
    문제 제목: 보석 상자
    주소: https://www.acmicpc.net/problem/2792
    알고리즘 분류: 이분 탐색, 매개변수 탐색
    풀이 날짜: 2022-07-14
*/

package July.Week2.P2792;

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
        int[] jew = new int[m];

        int left = 1, right = 0;
        for (int i = 0; i < m; i++) {
            jew[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, jew[i]);
        }

        int sum = 0;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            sum = 0;

            for (int i = 0; i < m; i++) {
                sum += jew[i] / mid;
                if (jew[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
