import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 반례 : n = 2 (1, 10), m = 8 (1, 1, 1, 1, 10, 10, 10, 10)
// 답이 4가 나와줘야 하지만 6이 나오게 된다 (크레인과 화물을 가벼운 순으로 정렬했기 때문이다)
class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 크레인의 수
        int[] cr = new int[n]; // 크레인의 무게 제한
        for (int i = 0; i < n; i++) {
            cr[i] = kb.nextInt();
        }
        Arrays.sort(cr);

        int m = kb.nextInt(); // 화물의 수
        PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 화물의 무게
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();

            if (cr[n - 1] < a) {
                System.out.println(-1);
                return;
            }
            pQ.offer(a);
        }

        int cnt = 0;

        while (!pQ.isEmpty()) {

            for (int i = 0; i < n; i++) {
                if (!pQ.isEmpty()) {
                    int num = pQ.poll();

                    if (num <= cr[i]) {
                        continue;
                    } else {
                        pQ.offer(num);
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }

}
