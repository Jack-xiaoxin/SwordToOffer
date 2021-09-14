package leetcodeQuestion;

public class Q0026 {

    public static void main(String[] args) {
        System.out.println(new Q0026().removeDuplicates(new int[]{1, 2, 3, 3, 3}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
