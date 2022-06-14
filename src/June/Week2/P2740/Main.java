/*
    문제 제목: 행렬 곱셈
    주소: https://www.acmicpc.net/problem/2740
    알고리즘 분류: 수학, 구현, 선형대수학
    풀이 날짜: 2022-06-14
*/
package June.Week2.P2740;

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
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int m2 = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] b = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    answer[i][j] += a[i][l] * b[l][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
