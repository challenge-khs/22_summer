/*
    문제 제목: 예산
    주소: https://www.acmicpc.net/problem/2512
    알고리즘 분류: 이분 탐색, 매개 변수 탐색
    풀이 날짜: 2022-06-06
*/

package June.Week1.P2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long m = Long.parseLong(br.readLine());

        Arrays.sort(arr);
        long start = 0;
        long end = arr[n - 1];
        long result = 0;

        while (start <= end) {
            long total = 0;
            long mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= mid) {
                    total += mid;
                } else {
                    total += arr[i];
                }
            }
            if (total > m) {
                end = mid - 1;
            } else {
                result = Math.max(mid, result);
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
