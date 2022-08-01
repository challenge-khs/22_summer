/*
    문제 제목: 숫자고르기
    주소: https://www.acmicpc.net/problem/2668
    알고리즘 분류: 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색
    풀이 날짜: 2022-08-01
*/

package August.Week1.P2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;

    static void dfs(int start, int value) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], value);
            visited[arr[start]] = false;
        }

        if(arr[start] == value)
            list.add(value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
