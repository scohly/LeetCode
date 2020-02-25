import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //LeetCode 40 :MEDIUM


        /**
         * Given a collection of candidate numbers, and a target number, find all unique combinations
         * in candidates where the candidate numbers sums to target
         *
         * each number in canddiate should only be used once
         *
         * ex: [10, 1, 2, 7, 6,1,5] target = 8,
         *
         * A solution set:
         * [
         * [1,7],
         * [1,2,6],
         * [2,6],
         * [1,1,6]
         * ]
         */

        //Hint : when asked for combinations or permutations use DFS with recursion


        public static List<List<Integer>> combinationSum2(int[] candidates, int target){
            List<List<Integer>> result = new ArrayList<>();
            //we want to sort our numbers so we know we're walking through candidate array in a specific order

            Arrays.sort(candidates);
            findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);

            return result;

        }

        public static void findCombinations(int[] candidates, int index,int target, List<Integer> current, List<List<Integer>> result){
            //now we need to first check the condition we are lookin for

            //basecase
            if(target == 0){
                result.add(new ArrayList<>(current));
                return;
            }
            if(target<0)
                return;

            for(int i = index; i < candidates.length; i++){
                if(i == index || candidates[i] != candidates[i-1]){
                    current.add(i);
                    findCombinations(candidates,i +1, target - candidates[i], current, result);
                    current.remove(current.size()-1);
                }
            }

        }

        public static void main(String [] args){
            System.out.println("TEST");
        }
}
