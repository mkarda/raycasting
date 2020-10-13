package Google;

public class FruitIntoBasket {

    public static void main(String[] args) {

        int[] input = {3,3,3,1,2,1,1,2,3,3,4};
        int i = totalFruit(input);

        System.out.println(i);

    }

    public static int totalFruit(int[] trees) {

        int l = 0;
        int firstType = -1, secondType = -1;

        int result = 0;
        for(int r = 0;r < trees.length;r++) {
            if(trees[r] == firstType || trees[r] == secondType) continue;

            if(firstType == -1) {
                firstType = trees[r];
                continue;
            }
            if(secondType == -1) {
                secondType = trees[r];
                continue;
            }

            result = Math.max(result, r - l);

            firstType = trees[r-1];
            secondType = trees[r];

            l = r-1;
            while( trees[l] == firstType) {
                --l;
            }
            ++l;
        }

        result = Math.max(result, trees.length - l);
        return result;
    }
}
