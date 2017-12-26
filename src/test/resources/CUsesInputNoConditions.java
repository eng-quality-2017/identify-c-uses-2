package bgu.testing.identifyCuses2;

public class CUsesInputNoConditions {

    private int codeDomain(int x, int y) {
        int c, d, k;
        c = x + y;

        d = c - x / 2;
        k = x + d / 2;
        c = d + 1;

        return k;
    }
}
