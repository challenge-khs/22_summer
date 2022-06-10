/*
    문제 제목: 먹을 것인가 먹힐 것인가
    주소: https://www.acmicpc.net/problem/7795
    알고리즘 분류: 정렬, 이분 탐색, 투 포인터
    풀이 날짜: 2022-06-10
*/

package June.Week2.P7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int binarySearch(int target) {
        int start = 0;
        int end = m - 1;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (b[mid] < target) {
                result = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    static int n, m;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            a = new int[n];
            b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int answer = 0;
            for (int i = 0; i < n; i++) {
                answer += binarySearch(a[i]);
            }

            System.out.println(answer);
        }
    }
}
