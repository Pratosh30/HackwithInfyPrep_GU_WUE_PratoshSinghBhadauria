class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = queries.length, n = s.length();
        int[] counts = new int[n+1];
        long[] sums = new long[n+1], pows = new long[n+1], pow10 = new long[n+1];
        long mod = (long) 1e9 + 7L, x = 0L, y = 1L;
        pow10[0] = 1;
        for (int i = 0; i < n; i++) {
            var d = s.charAt(i) - '0';
            sums[i+1] = sums[i] + d;
            pows[i+1] = (pows[i] * (d != 0 ? 10 : 1)) % mod + d;
            counts[i+1] = counts[i] + (d != 0 ? 1 : 0);
            pow10[i+1] = pow10[i] * 10 % mod;
        }
        var ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            long sum = sums[r+1] - sums[l], d = pow10[counts[r+1] - counts[l]];
            long lv = sum * pows[r+1] % mod, rv = (sum * pows[l] % mod) * d % mod;
            ans[i] = (int) ((lv - rv + mod) % mod);
        }
        return ans;
    }
}
