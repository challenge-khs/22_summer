/*
    문제 제목: 카드2
    주소: https://www.acmicpc.net/problem/2164
    알고리즘 분류: 자료 구조, 큐
    풀이 날짜: 2022-06-24
*/

package June.Week4.P2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.remove();
            int temp = q.poll();
            q.add(temp);
        }

        System.out.println(q.poll());
    }
}
