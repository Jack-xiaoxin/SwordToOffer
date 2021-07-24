package question35;

import java.util.Arrays;

//手写一个大顶堆来解题
public class Solve3 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,2,4,4,1,3,3,2};
        int[] result = new Solve3().getLeastNumbers(arr, 6);
        System.out.println(1);
    }

    //大顶堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) return new int[0];
        MaxHeap maxHeap = new MaxHeap(k);
        for(int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }
        return maxHeap.getArr();
    }


}

class MaxHeap {

    //节点个数，初始化为0
    private int size = 0;
    //容量
    private int capacity;
    //以数组形式存储的二叉树
    private int[] arr;

    //初始化
    //
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    //得到某节点的父节点
    public int getParentIndex(int index) {
        if(index == 0) throw new RuntimeException("已经是根节点了哦");
        return (index - 1) / 2;
    }

    //获得某节点的左子节点
    public int getLeftChildIndex(int index) {
        if(isHasLeftChild(index)) return index * 2 + 1;
        throw new RuntimeException("该节点没有左子节点");
    }

    //获得某节点的右子节点
    public int getRightChildIndex(int index) {
        if(isHasRightChild(index)) return index * 2 + 2;
        throw new RuntimeException("该节点没有右子节点");
    }

    //判断有没有左子节点
    public boolean isHasLeftChild(int index) {
        return index * 2 + 1 < size;
    }

    //判断有没有右子节点
    public boolean isHasRightChild(int index) {
        return index * 2 + 2 < size;
    }

    //从最后一个节点开始，往上进行调整
    public void adjustUp() {
        int index = size - 1;
        while(index != 0) {
            int parentIndex = getParentIndex(index);
            int largeIndex = getLeftChildIndex(parentIndex);
            if(isHasRightChild(parentIndex) && arr[getRightChildIndex(parentIndex)] > arr[largeIndex])
                largeIndex = getRightChildIndex(parentIndex);
            if(arr[parentIndex] < arr[largeIndex]) swap(parentIndex, largeIndex);

            index = getParentIndex(index);
        }
    }

    //从第一个节点开始，从上往下进行调整
    public void adjustDown() {
        int index = 0;
        while(isHasLeftChild(index)) {
            int largeIndex = getLeftChildIndex(index);
            if(isHasRightChild(index) && arr[getRightChildIndex(index)] > arr[largeIndex])
                largeIndex = getRightChildIndex(index);
            if(arr[index] < arr[largeIndex]) swap(index, largeIndex);
            index = largeIndex;
        }
    }

    //获得堆顶元素的值（也就是最大值）
    public int peek() {
        if(!isEmpty()) return arr[0];
        else throw new RuntimeException("还没有值哦");
    }

    //新增节点
    public void add(int val) {
        if(!isFull()) {
            arr[size++] = val;
            adjustUp();
        }
        else if(val < peek()){
            arr[0] = val;
            adjustDown();
        }
    }

    public void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2]  = temp;
    }

    public void push(int value) {
        if(!isFull()) {
            arr[size] = value;
            size++;

        }
    }

    public boolean isFull() {
        return capacity <= size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] getArr() {
        return arr;
    }
}
