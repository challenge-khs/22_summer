/*
    문제 제목: N번째 큰 수
    주소: https://www.acmicpc.net/problem/2075
    알고리즘 분류: 자료구조, 정렬, 우선순위 큐
    풀이 날짜: 2022-06-13
*/

package June.Week2.P2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
                if(pq.size() > n) {
                    pq.poll();
                }
            }
        }

        System.out.print(pq.poll());

    }
}
