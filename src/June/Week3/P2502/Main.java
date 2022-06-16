/*
    문제 제목: 떡 먹는 호랑이
    주소: https://www.acmicpc.net/problem/2502
    알고리즘 분류: 수학, 다이나믹 프로그래밍, 브루투포스 알고리즘
    풀이 날짜: 2022-06-16
*/

package June.Week3.P2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[d];

        for (int i = 1; i <= k / 2; i++) {
            for (int j = i + 1; j < k; j++) {
                arr[0] = i;
                arr[1] = j;
                for (int l = 2; l < d; l++) {
                    arr[l] = arr[l - 1] + arr[l - 2];
                }

                if (arr[d - 1] == k) {
                    System.out.println(arr[0]);
                    System.out.println(arr[1]);
                    System.exit(0);
                }
            }
        }
    }
}
