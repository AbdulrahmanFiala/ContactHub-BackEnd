import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueTripletsSum {

    public static List<List<Integer>> findUniqueTripletsIndices(int[] nums, int target) {
        // Sort the array, but we need to keep track of original indices, so we use a custom object.
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i; // Store original indices
        }

        // Sort the indices based on the values in nums
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        Set<List<Integer>> tripletsIndices = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[indices[i]] + nums[indices[left]] + nums[indices[right]];

                if (sum == target) {
                    // Sort the indices of the triplet to avoid duplicates in the set
                    Integer[] sortedTriplet = {indices[i], indices[left], indices[right]};
                    Arrays.sort(sortedTriplet);
                    tripletsIndices.add(Arrays.asList(sortedTriplet));

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(tripletsIndices);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;

        List<List<Integer>> result = findUniqueTripletsIndices(nums, target);

        System.out.println("Unique Triplets Indices:");
        for (List<Integer> tripletIndices : result) {
            System.out.println(tripletIndices);
        }
    }
}