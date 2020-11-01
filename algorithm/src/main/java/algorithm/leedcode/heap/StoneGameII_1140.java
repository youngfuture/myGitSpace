package algorithm.leedcode.heap;

/**
 * https://leetcode-cn.com/problems/stone-game-ii/
 */
public class StoneGameII_1140 {

    public static void main(String[] args) {
        StoneGameII_1140 stoneGameII_1140 = new StoneGameII_1140();
        System.out.println(stoneGameII_1140.stoneGameII(new int[]{1,2,3,4,5,100}));
    }

    //Ｍ＝１　,1 <= X <= 2M。然后，令 M = max(M, X)
    public int stoneGameII(int[] piles) {
        int firstStepForTwo = firstStepForTwo(piles);
        int firstStepForOne = firstStepForOne(piles);

        return firstStepForTwo > firstStepForOne ? firstStepForTwo : firstStepForOne;
    }

    private int firstStepForOne(int[] piles) {
        int firstTotal = 0;
        int secondTotal = 0;

        int m = 1;
        int start = 0;
        int totalPiles = 0;


        boolean isFirst = true;
        int currentSecondMaxScale=0;
        int currentFirstMaxScale = 0;
        while (true) {
            if (isFirst) {
                currentFirstMaxScale = 1;
                isFirst = false;
            } else {
                m = Math.max(m, currentSecondMaxScale);
                currentFirstMaxScale = 2 * m;
            }

            int end = start + currentFirstMaxScale - 1;
            firstTotal += getSumPiles(start, end, piles);
            start += currentFirstMaxScale;
            totalPiles += currentFirstMaxScale;
            if (totalPiles > piles.length || totalPiles >= 100) {
                break;
            }

            m = Math.max(m, currentFirstMaxScale);
            currentSecondMaxScale = 2 * m;
            end = start + currentSecondMaxScale - 1;
            secondTotal += getSumPiles(start, end, piles);
            start += currentSecondMaxScale;
            totalPiles += currentSecondMaxScale;
            if (totalPiles > piles.length || totalPiles >= 100) {
                break;
            }
        }

        return firstTotal;
    }

    private int firstStepForTwo(int[] piles) {
        int firstTotal = 0;
        int secondTotal = 0;

        int m = 1;
        int start = 0;
        int totalPiles = 0;
        while (true) {
            int currentFirstMaxScale = 2 * m;
            int end = start + currentFirstMaxScale - 1;
            firstTotal += getSumPiles(start, end, piles);
            start += currentFirstMaxScale;
            totalPiles += currentFirstMaxScale;
            if (totalPiles > piles.length || totalPiles >= 100) {
                break;
            }

            m = Math.max(m, currentFirstMaxScale);
            int currentSecondMaxScale = 2 * m;
            end = start + currentSecondMaxScale - 1;
            secondTotal += getSumPiles(start, end, piles);
            start += currentSecondMaxScale;
            totalPiles += currentSecondMaxScale;
            if (totalPiles > piles.length || totalPiles >= 100) {
                break;
            }
        }

        return firstTotal;
    }

    private int getSumPiles(int start, int end, int[] piles) {
        int sumStartToEnd = 0;
        for (int i = start; i <= end && i < piles.length; i++) {
            sumStartToEnd += piles[i];
        }
        return sumStartToEnd;
    }
}
