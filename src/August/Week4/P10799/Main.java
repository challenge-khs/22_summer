/*
    문제 제목: 쇠막대기
    주소: https://www.acmicpc.net/problem/10799
    알고리즘 분류: 자료구조, 스택
    풀이 날짜: 2022-08-25
*/

package August.Week4.P10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(now == '(') {
                stk.push(now);
            } else if (now == ')') {
                stk.pop();
                if (input.charAt(i - 1) == '(') {
                    sum += stk.size();
                } else {
                    sum ++;
                }
            }
        }

        System.out.println(sum);
    }
}
