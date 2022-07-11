/*
    문제 제목: 고층 건물
    주소: https://www.acmicpc.net/problem/1027
    알고리즘 분류: 수학, 브루트포스 알고리즘, 기하학
    풀이 날짜: 2022-07-11
*/

package July.Week2.P1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] cnt = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            cnt[i]++;
            cnt[i + 1]++;
            double slope = arr[i + 1] - arr[i];
            for (int j = i + 2; j <= n; j++) {
                double next = (double) (arr[j] - arr[i]) / (j - i);
                if (slope >= next)
                    continue;
                slope = next;
                cnt[i]++;
                cnt[j]++;
            }
        }

        Arrays.sort(cnt);
        System.out.println(cnt[cnt.length - 1]);
    }
}
