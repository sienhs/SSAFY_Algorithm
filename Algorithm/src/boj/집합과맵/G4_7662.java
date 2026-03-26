package boj.집합과맵;

import java.io.*;
import java.util.*;

public class G4_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine().trim());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String line = br.readLine();
                char op = line.charAt(0);
                int n = Integer.parseInt(line.substring(2));

                if (op == 'I') {
                    if (map.containsKey(n)) {
                        map.put(n, map.get(n) + 1);
                    } else {
                        map.put(n, 1);
                    }
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    int key;
                    if (n == 1) {
                        key = map.lastKey();   // 최댓값
                    } else {
                        key = map.firstKey();  // 최솟값
                    }

                    int count = map.get(key);
                    if (count == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, count - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
