import java.util.Arrays;

/**
 * 912. 排序数组
 * 给定一个整数数组 nums，将该数组升序排列。
 * */
public class SortArray_912 {

    public int[] sortArray(int[] nums) {

        heapSort(nums);
        return nums;
    }

    /**
     * 堆排序
     * */
    public void heapSort(int [] arr) {
        if(arr==null||arr.length<2) {
            return;
        }
        for(int i=0;i<arr.length;i++) {
            heapInsert(arr,i);//依次将数组中i位置上的数加进来，让它0~i之间的数形成大顶堆
        }
        int heapSize=arr.length;//堆大小heapSize一开始等于数组的全部
        swap(arr,0,--heapSize);//最后一个位置上的数与第一个位置上的数(堆顶元素)交换，堆大小减1，即最后一个位置上的数不动了
        while(heapSize>0) {
            System.out.println(" * " + Arrays.toString(arr));
            heapify(arr,0,heapSize);//从0位置开始，将当前形成的堆继续调整为一个大顶堆
            swap(arr,0,--heapSize);//最后一个位置上的数与第一个位置上的数(堆顶元素)交换，堆大小减1，即最后一个位置上的数不动了
        }
    }

    //建立大顶堆的过程
    public void heapInsert(int[] arr,int index) {
        while(arr[index] > arr[(index-1)/2]) {//当前index位置上的数若比其父结点上的数大，则交换他俩的位置
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;//然后index来到了它的父节点位置，继续上面的while
        }
    }

    //若有一个节点的值变小了，则需要往下沉(与其左右孩子中较大的数进行交换位置的)的操作
    public void heapify(int[] arr,int index,int heapSize) {
        int left=index*2+1;//左孩子下标
        while(left<heapSize) {//未越界，即该节点并非叶子节点，存在左孩子
            //该节点有右孩子，让largest作为左右孩子较大值的下标
            int largest=(left+1 < heapSize) && arr[left+1] > arr[left] ? left+1 : left;
            //让largest成为该节点与该节点左右孩子中较大值的下标
            largest=arr[largest] > arr[index] ? largest : index;
            if(largest==index) {
                break;
            }
            swap(arr,largest,index);//largest!=index
            index=largest;//该节点下标变成了较大孩子的下标
            left=index*2+1;//继续往下走，重复上面的while
        }
    }

    public void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    /**
     * 归并排序
     * */
    public static void mergeSort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;//因为需要拷贝所以要把临时数组的指针置0(即指向第一个元素)
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            System.out.println(" * "+ Arrays.toString(arr));
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }


    /**
     * 希尔排序
     * */
    public void hillSort(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }
        int i,j;
        int increment;
        int temp;
        for(increment=nums.length/2;increment>0;increment/=2) {
            for(i=increment;i<nums.length;i++) {
                temp=nums[i];
                for(j=i-increment;j>=0;j-=increment) {
                    if(temp<nums[j]) {
                        nums[j+increment]=nums[j];
                    }else
                        break;
                }
                nums[j+increment]=temp;
            }
        }
    }

    /**
     * 直接插入排序
     * */
    public void insertSort(int[] nums) {
        if(nums==null||nums.length==0)
            return;
        for (int i = 1;i < nums.length; i++) {
            int tmp = nums[i] , j = i;
            if (nums[j - 1] > tmp) {
                while (j >= 1 && nums[j - 1] > tmp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
            }
            nums[j] = tmp;
        }
    }

    /**
     * 简单选择排序
     * */
    public void selectionSort(int[] nums) {
        for (int i = 0;i < nums.length; i++) {
            int small_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[small_index]) {
                    small_index = j;
                }
            }
            if (i < small_index) {
                int tmp = nums[i];
                nums[i] = nums[small_index];
                nums[small_index] = tmp;
            }
        }
    }

    /**
     * 冒泡排序
     * */
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n-1; i ++) {
            boolean flag = true;
            for (int j = 0;j < n - i-1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = false;
                }
            }

            if (flag) break;
        }
    }



    /**
     * 快速排序
     * */
    private void quickSort(int nums[], int left , int right) {
        if (left < right) {
            int i = left , j = right,temp = nums[left];
            System.out.println(" * "+Arrays.toString(nums));
            while (i < j) {
                while (nums[j] > temp && i < j) j--;
                if (i < j){
                    nums[i] = nums[j]; i++;
                }
                while (nums[i] < temp && i < j) i++;
                if (i < j) {
                    nums[j] = nums[i]; j--;
                }
            }
            nums[i] = temp;
            quickSort(nums , left , i -1);
            quickSort(nums , i+1 , right);
        }
    }

    public static void main(String[] args) {
        SortArray_912 sortArray_912 = new SortArray_912();
        System.out.println(Arrays.toString(sortArray_912.sortArray(new int[]{3,1,0,2,4,9,8,6,7,5})));
    }

}
