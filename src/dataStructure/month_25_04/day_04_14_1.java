package dataStructure.month_25_04;
public class day_04_14_1 {


    //数组换位
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //选择排序
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for(int minIndex, i = 0; i< arr.length - 1; i++){
            minIndex = i;

            for(int j = minIndex + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);

        }



    }


    //冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
             return;
        }

        for (int end = arr.length - 1; end > 0; end--){
            for (int i = 0; i < end; i++){
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }


    //插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--){

                swap(arr,i,j);
            }
        }
    }


}
