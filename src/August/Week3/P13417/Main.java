/*
    문제 제목: 카드 문자열
    주소: https://www.acmicpc.net/problem/13417
    알고리즘 분류: 자료 구조, 문자열, 그리디 알고리즘
    풀이 날짜: 2022-08-15
*/

package August.Week3.P13417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Deque<Character> dq = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                char temp = st.nextToken().charAt(0);

                if (dq.isEmpty()) {
                    dq.add(temp);
                } else {
                    if (dq.getFirst() >= temp) {
                        dq.addFirst(temp);
                    } else {
                        dq.addLast(temp);
                    }
                }
            }

            while (dq.size() > 0) {
                sb.append(dq.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
