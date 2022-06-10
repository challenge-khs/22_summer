/*
    문제 제목: k번째 소수
    주소: https://www.acmicpc.net/problem/15965
    알고리즘 분류: 수학, 정수론, 소수 판정, 에라토스테네스의 채
    풀이 날짜: 2022-06-10
*/

package June.Week2.P15965;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        boolean[] prime = new boolean[50000001];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= 50000000; i++) {
            if(!prime[i]) {
                for (int j = 2; i * j <= 50000000; j++) {
                    prime[i * j] = true;
                }
            }
        }

        int cnt = 0;
        int answer = 0;
        for (int i = 0; i <= 50000000; i++) {
            if(!prime[i]) {
                cnt++;
                if(cnt == k) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
