import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ReMain {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Integer> cr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cr.add(kb.nextInt());
        }
        Collections.sort(cr, Collections.reverseOrder());

        int m = kb.nextInt();
        ArrayList<Integer> fr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            fr.add(kb.nextInt());
        }
        Collections.sort(fr, Collections.reverseOrder());

        if (cr.get(0) < fr.get(0)) {
            System.out.println(-1);
        } else {
            int cnt = 0;
            while (!fr.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < fr.size();) {
                    if (idx == n) {
                        break;
                    }

                    if (cr.get(idx) >= fr.get(i)) {
                        fr.remove(i);
                        idx++;
                    } else {
                        i++;
                    }
                }
                cnt++;
            }
            System.out.println(cnt);

        }
    }
}
