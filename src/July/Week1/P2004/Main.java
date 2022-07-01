/*
    문제 제목: 조합 0의 개수
    주소: https://www.acmicpc.net/problem/2004
    알고리즘 분류: 수학, 정수론
    풀이 날짜: 2022-06-30
*/

package July.Week1.P2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long count(long num, int div) {
        long cnt = 0;
        while(num >= div) {
            cnt += num / div;
            num /= div;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long cnt2 = count(n, 2) - count(n - m, 2) - count(m, 2);
        long cnt5 = count(n, 5) - count(n - m, 5) - count(m, 5);

        System.out.println(Math.min(cnt2, cnt5));
    }
}
