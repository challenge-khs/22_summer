/*
    문제 제목: 단어 공부
    주소: https://www.acmicpc.net/problem/1157
    알고리즘 분류: 구현, 문자열
    풀이 날짜: 2022-06-23
*/
package June.Week4.P1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                arr[temp - 'A']++;
            } else {
                arr[temp - 'a']++;
            }
        }

        int max = Integer.MIN_VALUE;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65);
            } else if (arr[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
