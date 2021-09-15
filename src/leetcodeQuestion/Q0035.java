package leetcodeQuestion;

public class Q0035 {

    public static void main(String[] args) {
        System.out.println(new Q0035().searchInsert((new int[]{1, 3, 5, 6}), 0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
           int mid = left + (right - left) / 2;
           if(nums[mid] > target) right = mid - 1;
           else if(nums[mid] < target) left = mid + 1;
           else return mid;
        }
        return left;
    }
}
