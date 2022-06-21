/*
    문제 제목: 부등호
    주소: https://www.acmicpc.net/problem/2529
    알고리즘 분류: 브루트포스 알고리즘, 백트래킹
    풀이 날짜: 2022-06-21
*/

package June.Week3.P2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> list;

    static boolean check(char a, char b, char c) {
        if (c == '<' && a > b) {
            return false;
        }
        if (c == '>' && a < b) {
            return false;
        }
        return true;
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            list.add(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            if (depth == 0 || check(num.charAt(depth - 1), (char) (i + '0'), arr[depth - 1])) {
                visited[i] = true;
                dfs(depth + 1, num + Integer.toString(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        visited = new boolean[10];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        dfs(0, "");
        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }
}
