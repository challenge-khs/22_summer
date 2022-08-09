/*
    문제 제목: 소수의 연속합
    주소: https://www.acmicpc.net/problem/1644
    알고리즘 분류: 수학, 정수론, 두 포인터, 소수 판정, 에라토스테네스의 체
    풀이 날짜: 2022-08-09
*/

package August.Week2.P1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[4000001];
        ArrayList<Integer> arr = new ArrayList<>();

        check[0] = true;
        check[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!check[i]) {
                for (int j = 2; i * j <= n; j++) {
                    check[i * j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                arr.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while (true) {
            if (sum >= n) {
                sum -= arr.get(start++);
            } else if (end == arr.size()) {
                break;
            } else {
                sum += arr.get(end++);
            }
            if (n == sum) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
