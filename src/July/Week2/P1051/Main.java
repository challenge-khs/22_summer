/*
    문제 제목: 숫자 정사각형
    주소: https://www.acmicpc.net/problem/1051
    알고리즘 분류: 구현, 브루트포스 알고리즘
    풀이 날짜: 2022-07-15
*/

package July.Week2.P1051;

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
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; (i + k < n) && (j + k < m); k++) {
                    if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
                        cnt = Math.max((k + 1) * (k + 1), cnt);
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
