/*
    문제 제목: 요세푸스 문제
    주소: https://www.acmicpc.net/problem/1158
    알고리즘 분류: 자료구조, 큐
    풀이 날짜: 2022-08-25
*/

package August.Week4.P1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            cnt++;

            if(cnt % k == 0) {
                System.out.print(temp + " ");
                continue;
            }
            q.add(temp);
        }
    }
}
