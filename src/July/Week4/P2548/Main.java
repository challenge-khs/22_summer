/*
    문제 제목: 대표 자연수
    주소: https://www.acmicpc.net/problem/2548
    알고리즘 분류: 브루트포스 알고리즘, 정렬
    풀이 날짜: 2022-07-29
*/

package July.Week4.P2548;

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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        if (arr.length == 1) {
            answer = arr[0];
        } else if (arr.length % 2 == 0) {
            answer = arr[arr.length / 2 - 1];
        } else {
            answer = arr[arr.length / 2];
        }

        System.out.println(answer);
    }
}
