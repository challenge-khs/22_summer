/*
    문제 제목: 지름길
    주소: https://www.acmicpc.net/problem/1446
    알고리즘 분류: 다이나믹 프로그래밍, 그래프 이론, 다익스트라
    풀이 날짜: 2022-07-08
*/

package July.Week1.P1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, d;

    static class Shortcut implements Comparable<Shortcut> {
        int s, e, l;

        public Shortcut(int s, int e, int l) {
            this.s = s;
            this.e = e;
            this.l = l;
        }

        @Override
        public int compareTo(Shortcut o) {
            return this.s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        ArrayList<Shortcut> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if(to > d)
                continue;
            if(to - from <= len)
                continue;
            arr.add(new Shortcut(from, to, len));
        }

        Collections.sort(arr);

        int idx = 0, move = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        while (move < d) {
            if (idx < arr.size()) {
                Shortcut temp = arr.get(idx);
                if (move == temp.s) {
                    dist[temp.e] = Math.min(dist[move] + temp.l, dist[temp.e]);
                    idx++;
                } else {
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }

        System.out.println(dist[d]);
    }
}
