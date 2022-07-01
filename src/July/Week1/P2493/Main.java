/*
    문제 제목: 탑
    주소: https://www.acmicpc.net/problem/2493
    알고리즘 분류: 자료 구조, 스택
    풀이 날짜: 2022-07-01
*/

package July.Week1.P2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] ans = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (stk.size() > 0) {
                if (arr[stk.peek()] >= arr[i]) {
                    ans[i] = stk.peek();
                    break;
                } else {
                    stk.pop();
                }
            }
            stk.push(i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
