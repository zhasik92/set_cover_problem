package another;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] subsets = {
                {0, 1, 3}, {2, 3, 4},
                 {1, 2, 4},
                {3, 4, 5}, {0, 2},{0, 2, 5}};
        SetCover setcover = new SetCover(6, 6);
        setcover.setSubsets(subsets);
        setcover.display();
        System.out.println(Arrays.toString(greedyScp(setcover)));
    }


    static boolean[] greedyScp(SetCover problem){
        boolean[] result = new boolean[problem.nbsubsets];
        int cover = 0;
        int select;
        for (int i = 0; i < problem.nbsubsets; i++) {
            result[i]=false;
        }
        while (cover!= problem.nbelements){
            select=problem.largestSubset();
            result[select] = true;
            cover += problem.cover(select);
            problem.update(select);
            problem.display();
        }
        return result;
    }
}
