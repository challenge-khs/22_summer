/*
    문제 제목: 부분 문자열
    주소: https://www.acmicpc.net/problem/16916
    알고리즘 분류: 문자열, kmp
    풀이 날짜: 2022-07-06
*/

package July.Week1.P16916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(kmp(str1, str2));
    }

    public static int[] getpi(String s) {
        int[] pi = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = j += 1;
            }
        }
        return pi;
    }

    public static int kmp(String s1, String s2) {
        int[] pi = getpi(s2);
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = pi[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                if (j == s2.length() - 1) {
                    return 1;
                } else {
                    j++;
                }
            }
        }
        return 0;
    }
}
