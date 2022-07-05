/*
    문제 제목: 시리얼 번호
    주소: https://www.acmicpc.net/problem/1431
    알고리즘 분류: 정렬
    풀이 날짜: 2022-07-05
*/

package July.Week1.P1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                            sum1 += (int)(o1.charAt(i) - '0');
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                            sum2 += (int)(o2.charAt(i) - '0');
                        }
                    }

                    if (sum1 == sum2) {
                        return o1.compareTo(o2);
                    } else {
                        return sum1 - sum2;
                    }
                }
                return 1;
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
