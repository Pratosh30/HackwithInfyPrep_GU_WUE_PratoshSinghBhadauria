class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int n = Math.min(50000, 3 * queries.length);
        int nn = Integer.highestOneBit(n);
        int nnn = n == nn ? nn * 2 : nn * 4;
        int[][] d = new int[nnn][3];
        int q = nnn;
        for (int i = 1; i < nnn; i++) {
            if (i == Integer.highestOneBit(i)) {
                q /= 2;
            }
            Arrays.fill(d[i], q);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                add(d, query[1]);
            } else {
                ans.add(get(d, query[1]) >= query[2]);
            }
        }
        return ans;
    }

    private void add(int[][] d, int x) {
        for (int ii = 0; ii <= 1; ii++) {
            int i = d.length / 2 + x - 1 + ii;
            if (ii == 0) {
                d[i][2] = 0;
            } else {
                d[i][0] = 0;
            }
            int size = 1;
            while (i > 1) {
                i /= 2;
                int[] cur = d[i];
                int[] l = d[2 * i];
                int[] r = d[2 * i + 1];
                cur[0] = l[0] == size ? l[0] + r[0] : l[0];
                cur[2] = r[2] == size ? r[2] + l[2] : r[2];
                cur[1] = Math.max(l[2] + r[0], Math.max(Math.max(cur[0], cur[2]), Math.max(l[1], r[1])));
                size *= 2;
            }
        }
    }

    private int get(int[][] d, int x) {
        int i = d.length / 2 + x - 1;
        int[] cur = new int[3];
        int[] prev = new int[]{d[i][0], d[i][1], d[i][2]};
        int size = 1;
        while (i > 1) {
            int iCur = i / 2;
            if (i % 2 == 1) {
                int[] l = d[2 * iCur];
                int[] r = prev;
                cur[0] = l[0] == size ? l[0] + r[0] : l[0];
                cur[2] = r[2] == size ? r[2] + l[2] : r[2];
                cur[1] = Math.max(l[2] + r[0], Math.max(Math.max(cur[0], cur[2]), Math.max(l[1], r[1])));
                int[] q = cur;
                cur = prev;
                prev = q;
            }
            size *= 2;
            i = iCur;
        }
        return prev[1];
    }
}