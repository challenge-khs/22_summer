/*
    문제 제목: 오등큰수
    주소: https://www.acmicpc.net/problem/17299
    알고리즘 분류: 자료구조, 스택
    풀이 날짜: 2022-08-26
*/

package August.Week4.P17299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        int[] F = new int[1000001];
        int[] ans = new int[n + 1];
        Stack<Integer> s = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            F[A[i]]++;
        }
/*
        for (int i = 1; i <= n; i++) {
            System.out.print(F[i] + " ");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(F[A[i]] + " ");
        }
 */
        for (int i = 1; i <= n; i++) {
            while (!s.isEmpty() && F[A[i]] > F[A[s.peek()]]) {
                ans[s.pop()] = A[i];
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            ans[s.pop()] = -1;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);
    }
}
