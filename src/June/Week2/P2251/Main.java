/*
    문제 제목: 물통
    주소: https://www.acmicpc.net/problem/2740
    알고리즘 분류: 수학, 구현, 선형대수학
    풀이 날짜: 2022-06-14
    참고: https://loosie.tistory.com/513
*/

package June.Week2.P2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] water;
    static boolean[][] check;
    static TreeSet<Integer> answer;

    static void dfs(int a, int b, int c) {
        if(check[a][b])
            return;
        if(a == 0)
            answer.add(c);
        check[a][b] = true;

        if (a + b > water[1]) {
            dfs((a + b) - water[1], water[1], c);
        } else {
            dfs(0, a + b, c);
        }

        if (a + b > water[0]) {
            dfs(water[0], (a + b) - water[0], c);
        } else {
            dfs(a + b, 0, c);
        }

        if (b + c > water[1]) {
            dfs(a, water[1], b + c - water[1]);
        } else {
            dfs(a, b + c, 0);
        }

        dfs(a, 0, b + c);
        dfs(0, b, a + c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        water = new int[3];
        check = new boolean[201][201];
        for (int i = 0; i < 3; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        answer = new TreeSet<>();
        dfs(0, 0, water[2]);

        for (Integer value : answer) {
            System.out.print(value + " ");
        }
    }
}
