/*
    문제 제목: 이분 그래프
    주소: https://www.acmicpc.net/problem/1707
    알고리즘 분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
    풀이 날짜: 2022-06-06
*/

package June.Week1.P1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int RED = 1;
    static final int BLUE = -1;
    static boolean flag;
    static int v;
    static int e;
    static int[] colors;
    static ArrayList<Integer> arr[];

    static void bfs(int start, int color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = color;

        while (!q.isEmpty() && flag) {
            int temp = q.poll();

            for (int i = 0; i < arr[temp].size(); i++) {
                int next = arr[temp].get(i);

                if(colors[next] == 0) {
                    q.add(next);
                    colors[next] = colors[temp] * -1;
                } else if (colors[next] + colors[temp] != 0) {
                    flag = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            flag = true;

            arr = new ArrayList[v + 1];
            colors = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                arr[u].add(v);
                arr[v].add(u);
            }

            for (int i = 1; i <= v; i++) {
                if (!flag)
                    break;
                if (colors[i] == 0) {
                    bfs(i, RED);
                }
            }

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
