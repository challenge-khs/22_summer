/*
    문제 제목: DSLR
    주소: https://www.acmicpc.net/problem/9019
    알고리즘 분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색
    풀이 날짜: 2022-08-19
*/

package August.Week3.P9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Num {
        int num;
        String cmd;

        public Num(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            Queue<Num> q = new LinkedList<>();

            q.add(new Num(a, ""));
            visited[a] = true;

            while (!q.isEmpty()) {
                Num temp = q.poll();
                int now = temp.num;
                String cmd = temp.cmd;

                if (now == b) {
                    System.out.println(cmd);
                    break;
                }

                int next = (now * 2) % 10000;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Num(next, cmd + "D"));
                }
                next = now == 0 ? 9999 : now - 1;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Num(next, cmd + "S"));
                }

                next = now / 1000 + (now % 1000) * 10;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Num(next, cmd + "L"));
                }

                next = (now % 10) * 1000 + now / 10;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Num(next, cmd + "R"));
                }
            }
        }
    }
}
