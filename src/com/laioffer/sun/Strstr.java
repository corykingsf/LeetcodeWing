package com.laioffer.sun;

public class Strstr {
    public int strstr(String large, String small) {
        if (large.length() <small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        int patternLen = small.length();
        long patternHash = hash(small,  patternLen);
        long txtHash = hash(large, patternLen);
        if (patternHash == txtHash && check(large, 0, small, patternLen)) {
            return 0;
        }
        // pre-compute R^(patternLen - 1) for use in removing leading digit
        long RM = 1;
        for (int i = 1; i <= patternLen - 1; i++) {
            RM = (31 * RM) % 101;
        }

        for (int i = patternLen; i < large.length(); i++) {
            txtHash = (txtHash + 101 - RM *large.charAt(i - patternLen) % 101) % 101;
            txtHash = (txtHash * 31 + large.charAt(i)) % 101;

            int offset = i - patternLen +1;
            if (patternHash == txtHash && check(large, offset, small, patternLen)) {
                return offset;
            }
        }
        return -1;
    }

    // Las Vegas version: does pat[] match txt[i..i-m+1] ?
    private boolean check(String txt, int i, String pat, int m) {
        for (int j = 0; j < m; j++)
            if (pat.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }
    // Compute hash for key[0..m-1].
    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (31 * h + key.charAt(j)) % 101;
        return h;
    }
}
