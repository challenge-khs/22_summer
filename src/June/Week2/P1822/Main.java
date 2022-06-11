/*
    문제 제목: 차집합
    주소: https://www.acmicpc.net/problem/1822
    알고리즘 분류: 자료 구조, 정렬, 해시를 사용한 집합과 맵
    풀이 날짜: 2022-06-11
*/

package June.Week2.P1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> a = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (a.contains(temp)) {
                a.remove(temp);
            }
        }

        System.out.println(a.size());

        for (Integer value : a) {
            System.out.print(value + " ");
        }
    }
}
