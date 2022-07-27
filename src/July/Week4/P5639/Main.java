/*
    문제 제목: 이진 검색 트리
    주소: https://www.acmicpc.net/problem/5639
    알고리즘 분류: 그래프 이론, 그래프 탐색, 트리, 재귀
    풀이 날짜: 2022-07-27
*/

package July.Week4.P5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
        void insert(int n) {
            if (n < this.value) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        if(node.left != null)
            postOrder(node.left);
        if(node.right != null)
            postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }
}
