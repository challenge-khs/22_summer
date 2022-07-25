/*
    문제 제목: 체인
    주소: https://www.acmicpc.net/problem/2785
    알고리즘 분류: 그리디 알고리즘, 정렬
    풀이 날짜: 2022-07-25
*/

package July.Week4.P2785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int cnt = 0;
        while (arr.size() > 1) {
            arr.set(0, arr.get(0) - 1);
            arr.remove(arr.size() - 1);
            if(arr.get(0) == 0)
                arr.remove(0);

            cnt++;
        }

        System.out.println(cnt);
    }
}
