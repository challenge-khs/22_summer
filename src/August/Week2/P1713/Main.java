/*
    문제 제목: 후보 추천하기
    주소: https://www.acmicpc.net/problem/1713
    알고리즘 분류: 구현, 시뮬레이션
    풀이 날짜: 2022-08-08
*/

package August.Week2.P1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Student implements Comparable<Student> {
        int time;
        int num;
        int cnt;

        public Student(int time, int num, int cnt) {
            this.time = time;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Student o) {
            if (this.cnt == o.cnt) {
                return this.time - o.time;
            }
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Student> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            boolean flag = false;
            if (arr.size() < n) {
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(j).num == temp) {
                        arr.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    arr.add(new Student(i, temp, 1));
            } else {
                Collections.sort(arr);
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(j).num == temp) {
                        arr.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    arr.remove(0);
                    arr.add(new Student(i, temp, 1));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            result.add(arr.get(i).num);
        }
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
