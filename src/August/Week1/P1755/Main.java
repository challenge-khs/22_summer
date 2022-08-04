/*
    문제 제목: 숫자놀이
    주소: https://www.acmicpc.net/problem/1755
    알고리즘 분류: 수학, 문자열, 정렬
    풀이 날짜: 2022-08-03
*/

package August.Week1.P1755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Word implements Comparable<Word> {
        String s;
        int v;

        public Word(String s, int v) {
            this.s = s;
            this.v = v;
        }

        @Override
        public int compareTo(Word o) {
            return s.compareTo(o.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        ArrayList<Word> list = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] temp = Integer.toString(i).toCharArray();
            for (int j = 0; j < temp.length; j++) {
                sb.append(num[temp[j] - '0'] + " ");
            }
            list.add(new Word(sb.toString(), i));
        }

        Collections.sort(list);

        int t = 0;
        for (Word word : list) {
            System.out.print(word.v + " ");
            t++;
            if (t % 10 == 0) {
                System.out.println();
            }
        }
    }
}
