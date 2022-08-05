/*
    문제 제목: 도서관
    주소: https://www.acmicpc.net/problem/1461
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-08-05
*/

package August.Week1.P1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) {
                pq.add(temp);
            } else {
                nq.add(Math.abs(temp));
            }
        }

        int finish = 0;
        if (pq.isEmpty()) {
            finish = nq.peek();
        } else if (nq.isEmpty()) {
            finish = pq.peek();
        } else {
            finish = Math.max(pq.peek(), nq.peek());
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            cnt += pq.peek() * 2;
            for (int i = 0; i < m; i++) {
                pq.poll();
            }
        }
        while (!nq.isEmpty()) {
            cnt += nq.peek() * 2;
            for (int i = 0; i < m; i++) {
                nq.poll();
            }
        }

        cnt -= finish;
        System.out.println(cnt);
    }
}
