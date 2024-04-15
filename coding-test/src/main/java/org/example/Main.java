package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        double[] scores = Stream.of(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        double maxScore = -1;

        double sum = 0;
        for (double score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
            sum += score;
        }

        bw.write(String.valueOf( sum / maxScore * 100 / n));
        bw.flush();
        br.close();
        bw.close();

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}