/*
    문제 제목: 수열의 합
    주소: https://www.acmicpc.net/problem/1024
    알고리즘 분류: 수학
    풀이 날짜: 2022-07-20
*/

package July.Week3.P1024;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        boolean flag = true;

        for (long i = l; i <= 100 && flag; i++) {
            long sum = (i * (i - 1)) / 2;
            long idx = 0;

            while (true) {
                if (sum == n) {
                    for (long k = 0; k < i; k++) {
                        bw.write(idx + k + " ");
                    }
                    flag=false;
                    break;
                }
                sum += i;
                idx++;
                if (sum > n) {
                    break;
                }
            }
        }

        if(flag)
            bw.write("-1");
        bw.write("\n");
        bw.flush();
    }
}
