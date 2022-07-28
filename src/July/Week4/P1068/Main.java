/*
    문제 제목: 트리
    주소: https://www.acmicpc.net/problem/1068
    알고리즘 분류: 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색
    풀이 날짜: 2022-07-28
*/

package July.Week4.P1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, cnt;
    static int[] parents;
    static boolean[] visited;

    public static void deleteNode(int a) {
        parents[a] = -2;
        for (int i = 0; i < n; i++) {
            if (parents[i] == a) {
                deleteNode(i);
            }
        }
    }

    public static void countNode(int b) {
        boolean flag = true;
        visited[b] = true;
        if(parents[b] != -2) {
            for (int i = 0; i < n; i++) {
                if (parents[i] == b && visited[i] == false) {
                    countNode(i);
                    flag = false;
                }
            }
            if(flag) cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cnt = 0;
        parents = new int[n];
        visited = new boolean[n];

        int root = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1)
                root = i;
        }

        int del = Integer.parseInt(br.readLine());
        deleteNode(del);
        countNode(root);

        System.out.println(cnt);
    }
}
