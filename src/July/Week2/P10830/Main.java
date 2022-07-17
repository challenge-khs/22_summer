/*
    문제 제목: 숫자 정사각형
    주소: https://www.acmicpc.net/problem/10830
    알고리즘 분류: 수학, 분할 정복, 선형대수학
    풀이 날짜: 2022-07-17
*/

package July.Week2.P10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] a;

    static int[][] solve(int[][] mat, long exp) {
        if (exp == 1) {
            return mat;
        }
        int[][] ret = solve(mat, exp / 2);

        ret = mul(ret, ret);
        if (exp % 2 == 1) {
            ret = mul(ret, mat);
        }

        return ret;
    }

    static int[][] mul(int[][] m1, int[][] m2) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ret[i][j] += m1[i][k] * m2[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = solve(a, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
