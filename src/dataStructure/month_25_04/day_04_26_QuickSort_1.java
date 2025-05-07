package dataStructure.month_25_04;

public class day_04_26_QuickSort_1 {

    public static int first, last;
    public static int[] sortArray(int[] nums){
        if (nums.length > 1) {
            
        }
        return nums;
    }

    public static void quickSort(int l, int r, int[] arr){
        if ( l >= r) {
            return;
        }

        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition(l, r, x, arr);
        int left = first;
        int right = last;
        quickSort(l, left - 1, arr);
        quickSort(right + 1, r, arr);
        
    } 


    public static void partition(int l, int r, int x, int[] arr){
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            }else if (arr[i] < x) {
                swap(i++, first++, arr);
            }else {
                swap(i,last--,arr);
            }
        }
    }

    public static void swap(int a, int b, int[] arr){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
