package leetcodeQuestion;

public class Q0004 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2,3};
        System.out.println(new Q0004().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = (nums1.length + nums2.length);
        if(num == 1) return nums1.length != 0 ? nums1[0] : nums2[0];
        int[] result = new int[num];
        int i = 0, j = 0, index = 0;
        while(i < nums1.length && j < nums2.length && index < result.length) {
            int temp = 0;
            if(nums1[i] < nums2[j]) {
                temp = nums1[i++];
            } else temp = nums2[j++];
            result[index++] = temp;
        }
        while(i < nums1.length && index < result.length) result[index++] = nums1[i++];
        while(j < nums2.length && index < result.length) result[index++] = nums2[j++];
        if(result.length % 2 == 0) return (result[result.length/2-1] + result[result.length/2]) / 2.0;
        else return result[result.length/2];
    }
}
