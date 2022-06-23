package another;

public class SetCover {
    int nbelements;
    int nbsubsets;
    boolean[][] incidenceMatrix;

    SetCover(int nn, int mm) {
        this.nbelements = nn;
        this.nbsubsets = mm;
        incidenceMatrix = new boolean[nbsubsets][nbelements];

        for (int i = 0; i < nbsubsets; i++)
            for (int j = 0; j < nbelements; j++)
                incidenceMatrix[i][j] = false;
    }

    void setSubsets(int[][] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[j].length; i++)
                incidenceMatrix[j][array[j][i]] = true;
        }
    }

    void display() {
        for (int i = 0; i < nbsubsets; i++) {
            for (int j = 0; j < nbelements; j++)
                if (incidenceMatrix[i][j]) System.out.print("1");
                else System.out.print("0");
            System.out.println("");
        }
    }

    int cover(int i) {
        int nbEl = 0;
        for (int j = 0; j < nbelements; j++)
            if (incidenceMatrix[i][j]) ++nbEl;
        return nbEl;
    }

    int largestSubset() {
        int i, nbel, max, select;
        max = -1;
        select = -1;
        for (i = 0; i < nbsubsets; i++) {
            nbel = cover(i);
            if (nbel > max) {
                max = nbel;
                select = i;
            }
        }
        return select;
    }

    void update(int sel) {
        int i, j;
        for (i = 0; i < nbsubsets; i++) {
            if (i != sel) {
                for (j = 0; j < nbelements; j++)
                    if (incidenceMatrix[sel][j]) incidenceMatrix[i][j] = false;
            }
        }
        for (j = 0; j < nbelements; j++)
            incidenceMatrix[sel][j] = false;
    }
}