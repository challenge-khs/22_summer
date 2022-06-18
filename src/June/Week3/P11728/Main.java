/*
    문제 제목: 배열 합치기
    주소: https://www.acmicpc.net/problem/11728
    알고리즘 분류: 정렬, 투 포인터
    풀이 날짜: 2022-06-18
*/

package June.Week3.P11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int a = 0, b = 0, idx = 0;
        while (a < listA.size() && b < listB.size()) {
            if (listA.get(a) > listB.get(b)) {
                result.add(listB.get(b));
                b++;
            } else {
                result.add(listA.get(a));
                a++;
            }
        }

        while (a < listA.size()) {
            result.add(listA.get(a++));
        }
        while (b < listB.size()) {
            result.add(listB.get(b++));
        }

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }
        System.out.println(sb);
    }
}
