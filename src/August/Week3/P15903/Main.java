/*
    문제 제목: 카드 합체 놀이
    주소: https://www.acmicpc.net/problem/15903
    알고리즘 분류: 자료 구조, 그리디 알고리즘, 우선순위 큐
    풀이 날짜: 2022-08-17
*/

package August.Week3.P15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0) {
            long temp = pq.poll();
            temp += pq.poll();
            pq.add(temp);
            pq.add(temp);
        }

        long sum = 0;
        for (Long v : pq) {
            sum += v;
        }

        System.out.println(sum);
    }
}
