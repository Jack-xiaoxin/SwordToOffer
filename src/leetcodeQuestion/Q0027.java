package leetcodeQuestion;

public class Q0027 {

    public static void main(String[] args) {
        System.out.println(new Q0027().removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) nums[index++] = nums[i];
        }
        return index;
    }
}
