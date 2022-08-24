/*
    문제 제목: 단어 뒤집기
    주소: https://www.acmicpc.net/problem/9093
    알고리즘 분류: 구현, 문자열
    풀이 날짜: 2022-08-24
*/

package August.Week4.P9093;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuffer sb;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb = new StringBuffer(st.nextToken());
                String reversed = sb.reverse().toString();
                bw.write(reversed + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
