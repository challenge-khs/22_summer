/*
    문제 제목: 0 만들기
    주소: https://www.acmicpc.net/problem/7490
    알고리즘 분류: 구현, 문자열, 브루트포스 알고리즘, 파싱, 백트래킹
    풀이 날짜: 2022-08-10
*/


package August.Week2.P7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] op = {"+", "-", " "};
    static ArrayList<String> answer;

    static void dfs(int depth, String s) {
        if (depth == n) {
            String sik = s.replaceAll(" ", "");

            StringTokenizer st = new StringTokenizer(sik, "+|-", true);
            int sum = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                if (temp.equals("+")) {
                    sum += Integer.parseInt(st.nextToken());
                } else {
                    sum -= Integer.parseInt(st.nextToken());
                }
            }

            if(sum == 0) {
                answer.add(s);
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(depth + 1, s + op[i] + Integer.toString(depth + 1));
            //System.out.println(s + op[i] + Integer.toString(n + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            answer = new ArrayList<>();
            dfs(1, "1");

            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
            System.out.println();
        }
    }
}
