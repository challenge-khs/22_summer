/*
    문제 제목: 파일 정리
    주소: https://www.acmicpc.net/problem/20291
    알고리즘 분류: 자료 구조, 문자열, 정렬, 파싱, 해시를 이용한 집합과 맵, 트리를 사용한 집합과 맵
    풀이 날짜: 2022-07-10
*/

package July.Week1.P20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String temp = st.nextToken();
            if (map.containsKey(temp)) {
                int cnt = map.get(temp);
                map.replace(temp, ++cnt);
            } else {
                map.put(temp, 1);
            }
        }

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
