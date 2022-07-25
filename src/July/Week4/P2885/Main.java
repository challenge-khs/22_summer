package July.Week4.P2885;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int size, cnt, temp;
        size = 0;
        temp = 1;
        cnt = 0;

        while (temp < k) {
            temp *= 2;
            size = temp;
        }

        while (k > 0) {
            if (k >= temp) {
                k -= temp;
            } else {
                temp /= 2;
                cnt++;
            }
        }

        System.out.println(size + " " + cnt);
    }
}
