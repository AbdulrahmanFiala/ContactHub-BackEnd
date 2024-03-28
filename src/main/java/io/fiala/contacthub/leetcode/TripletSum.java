import java.util.*;

public class TripletSum {
    public static List<int[]> findTriplets(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(new int[] {i, left, right});

                    // skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<int[]> triplets = findTriplets(nums, target);

        for (int[] triplet : triplets) {
            System.out.println("[" + triplet[0] + ", " + triplet[1] + ", " + triplet[2] + "]");
        }
    }
}