package question18;

public class Solve {

    public static void main(String[] args) {

    }

    //思路：两个指针，一个从前往后扫找偶数，一个从后往前扫找奇数，分别找到后，将这两个数交换位置
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length <= 1) return nums;
        int p1 = 0, p2 = nums.length - 1;
        while(p1 < p2) {
            while(p1 < p2 && nums[p1] % 2 == 1) p1++;
            while(p1 < p2 && nums[p2] % 2 == 0) p2--;
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
        return nums;
    }

}
