/*
    문제 제목: 수리공 항승
    주소: https://www.acmicpc.net/problem/1449
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-06-07
*/

package June.Week1.P1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int first = 0;
        if(n != 0) {
            first = arr[0] + l - 1;
            cnt++;
        }

        for (int i = 1; i < n; i++) {
            if(first < arr[i]) {
                first = arr[i] + l - 1;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
