/*
    문제 제목: 이장님 초대
    주소: https://www.acmicpc.net/problem/9237
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-06-12
*/

package June.Week2.P9237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        int max = 0;
        for (int i = 0; i < n; i++) {
            tree[n - i - 1] = tree[n - i - 1] + i + 1;
            max = Math.max(max, tree[n - i - 1]);
        }

        System.out.println(max + 1);
    }
}

