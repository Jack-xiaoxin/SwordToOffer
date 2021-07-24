package question35;

import java.util.Arrays;

//快速排序来解题
public class Solve4 {

    private int[] result;

    public static void main(String[] args) {
        int[] result = new Solve4().getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);
        System.out.println(Arrays.toString(result));
    }

    //快速排序，从小到大排，直到遇到某一个节点，它左边的元素个数为k
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) return new int[0];
        if(k >= arr.length) return arr;
        recur(arr, k, 0, arr.length-1);
        return result;
    }

    public void recur(int[] arr, int k, int left, int right) {
        if(result != null) return ;
        int l = left;
        int r = right;
        int number  = arr[left];
        int index = left;
        while(left < right) {
            while(arr[right] >= number && right > left) right--;
            if(arr[right] < number) {
                arr[left] = arr[right];
                arr[right] = number;
                index = right;
            }
            while(arr[left] <= number && right > left) left++;
            if(arr[left] > number) {
                arr[right] = arr[left];
                arr[left] = number;
                index = left;
            }
        }
        if(index == k) result = Arrays.copyOfRange(arr, 0, index);
        else if(index < k) recur(arr, k, index+1, r);
        else recur(arr, k, 0, index);
    }
}
