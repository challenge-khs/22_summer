/*
    문제 제목: 단어 뒤집기
    주소: https://www.acmicpc.net/problem/17413
    알고리즘 분류: 구현, 자료구조, 문자열, 스택
    풀이 날짜: 2022-08-24
*/

package August.Week4.P17413;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (now == '<') {
                flag = true;
                while (!stk.isEmpty()) {
                    System.out.print(stk.pop());
                }
            } else if (now == '>') {
                flag = false;
                System.out.print(now);
                continue;
            }

            if (flag) {
                System.out.print(now);
                continue;
            }

            if (now == ' ') {
                while (!stk.isEmpty()) {
                    System.out.print(stk.pop());
                }
                System.out.print(" ");
            } else {
                stk.push(now);
            }
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop());
        }
    }
}
