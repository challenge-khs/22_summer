/*
    문제 제목: 반복수열
    주소: https://www.acmicpc.net/problem/2331
    알고리즘 분류: 수학, 구현
    풀이 날짜: 2022-08-14
*/

package August.Week2.P2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a);

        while (true) {
            int temp = arr.get(arr.size() - 1);
            int result = 0;

            while (temp != 0) {
                result += (int) Math.pow(temp % 10, (double) p);
                temp /= 10;
            }

            if (arr.contains(result)) {
                int ans = arr.indexOf(result);
                System.out.println(ans);
                break;
            }

            arr.add(result);
        }
    }
}
