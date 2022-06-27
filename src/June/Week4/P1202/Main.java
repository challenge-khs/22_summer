/*
    문제 제목: 보석 도둑
    주소: https://www.acmicpc.net/problem/1202
    알고리즘 분류: 자료 구조, 그리디 알고리즘, 정렬, 우선순위 큐
    풀이 날짜: 2022-06-27
*/

package June.Week4.P1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Jew implements Comparable<Jew> {
        int m, v;

        public Jew(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jew o) {
            return this.m - o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jew[] j = new Jew[n];
        int[] c = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            j[i] = new Jew(m, v);
        }

        for (int i = 0; i < k; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(j);
        Arrays.sort(c);

        long sum = 0;
        int idx = 0;
        PriorityQueue<Jew> pq = new PriorityQueue<>((x, y) -> y.v - x.v);
        for (int i = 0; i < k; i++) {
            while (idx < n && j[idx].m <= c[i]) {
                pq.add(new Jew(j[idx].m, j[idx].v));
                idx++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll().v;
            }
        }

        System.out.println(sum);
    }
}
