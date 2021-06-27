package question3;

import java.util.Arrays;

public class Solve2 {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        solve(nums1, 0, nums2, 1);
    }

    public static void solve(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        int i = m-1, j = n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) nums1[p--] = nums1[i--];
            else nums1[p--] = nums2[j--];
        }
        while(i >= 0) nums1[p--] = nums1[i--];
        while(j >= 0) nums1[p--] = nums2[j--];
        System.out.println(Arrays.toString(nums1));
    }
}
