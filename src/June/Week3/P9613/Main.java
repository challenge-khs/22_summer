/*
    문제 제목: GCD 합
    주소: https://www.acmicpc.net/problem/9613
    알고리즘 분류: 수학, 브루트포스 알고리즘, 정수론, 유클리드 호제법
    풀이 날짜: 2022-06-19
*/

package June.Week3.P9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long sum = 0l;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = gcd(arr[i], arr[j]);
                    //System.out.println(temp);
                    sum += temp;
                }
            }

            System.out.println(sum);
        }
    }
}
