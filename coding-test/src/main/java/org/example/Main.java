package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public class AbsoluteValue implements Comparable<AbsoluteValue> {
        private int x;

        public AbsoluteValue(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(AbsoluteValue absoluteValue) {
            if (Math.abs(this.x) > Math.abs(absoluteValue.x)) {
                return 1;
            } else if (Math.abs(this.x) == Math.abs(absoluteValue.x)) {
                if (this.x > absoluteValue.x) {
                    return 1;
                } else {
                    return -1;
                }
            }

            return -1;
        }

        @Override
        public String toString() {
            return String.valueOf(x);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<AbsoluteValue> priorityQueue = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                priorityQueue.add(new AbsoluteValue(x));
            } else {
                if (priorityQueue.isEmpty()) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(priorityQueue.poll()));
                    bw.newLine();
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}