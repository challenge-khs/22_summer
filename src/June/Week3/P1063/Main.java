/*
    문제 제목: 킹
    주소: https://www.acmicpc.net/problem/1063
    알고리즘 분류: 구현, 시뮬레이션
    풀이 날짜: 2022-06-17
*/

package June.Week3.P1063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static Pos king, stone;

    static void move(int idx) {
        int nkx = king.x + dx[idx];
        int nky = king.y + dy[idx];

        if (nkx >= 1 && nkx <= 8 && nky >= 1 && nky <= 8) {
            if (nkx == stone.x && nky == stone.y) {
                int nsx = stone.x + dx[idx];
                int nsy = stone.y + dy[idx];
                if (nsx >= 1 && nsx <= 8 && nsy >= 1 && nsy <= 8) {
                    stone.x = nsx;
                    stone.y = nsy;
                    king.x = nkx;
                    king.y = nky;
                }
            } else {
                king.x = nkx;
                king.y = nky;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input1 = st.nextToken();
        String input2 = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        king = new Pos(input1.charAt(1) - '0', input1.charAt(0) - 'A' + 1);
        stone = new Pos(input2.charAt(1) - '0', input2.charAt(0) - 'A' + 1);

        for (int i = 0; i < n; i++) {
            String order = br.readLine();

            int idx;
            if(order.equals("R")) {
                idx = 0;
            } else if (order.equals("L")) {
                idx = 1;
            } else if (order.equals("B")) {
                idx = 2;
            } else if (order.equals("T")) {
                idx = 3;
            } else if (order.equals("RT")) {
                idx = 4;
            } else if (order.equals("LT")) {
                idx = 5;
            } else if (order.equals("RB")) {
                idx = 6;
            } else {
                idx = 7;
            }

            move(idx);
        }
        char ky = (char) ('A' + king.y - 1);
        char sy = (char) ('A' + stone.y - 1);
        System.out.println(ky + "" + king.x);
        System.out.println(sy + "" + stone.x);
    }
}
