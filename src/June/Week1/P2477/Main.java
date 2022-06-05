/*
    문제 제목: 숫자의 개수
    주소: https://www.acmicpc.net/problem/2477
    알고리즘 분류: 구현, 기하학
    풀이 날짜: 2022-06-05
*/

package June.Week1.P2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int hMax = Integer.MIN_VALUE;
        int hMin = Integer.MAX_VALUE;
        int wMax = Integer.MIN_VALUE;
        int wMin = Integer.MAX_VALUE;
        int[] arr = new int[6];
        int[] dir = new int[6];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if (dir[i] == 1 || dir[i] == 2) {
                wMax = Math.max(wMax, arr[i]);
            } else {
                hMax = Math.max(hMax, arr[i]);
            }
        }

        for (int i = 0; i < 6; i++) {
            int before = (i + 5) % 6;
            int next = (i + 1) % 6;

            if (dir[before] == dir[next]) {
                if (dir[i] == 1 || dir[i] == 2) {
                    wMin = arr[i];
                } else {
                    hMin = arr[i];
                }
            }
        }

        int answer = k * (hMax * wMax - hMin * wMin);
        System.out.println(answer);
    }
}
